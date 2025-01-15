package bookstore.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import bookstore.controller.DocGiaController;
import bookstore.model.DocGiaModel;
import bookstore.share.MenuBarAdmin;

public class GiaHanTheView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtMaThe;
    private JTextField txtTenDocGia;
    private JFormattedTextField txtNgayHetHan;
    private DocGiaController docGiaController;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GiaHanTheView frame = new GiaHanTheView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public GiaHanTheView() {
        docGiaController = new DocGiaController();

        setTitle("Gia Hạn Thẻ");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 300);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(new BorderLayout(10, 10));
        setContentPane(contentPane);
        
     // Tích hợp MenuBarAdmin
     		MenuBarAdmin menuBarAdmin = new MenuBarAdmin();
     		setJMenuBar(menuBarAdmin);

        // Tiêu đề "Gia hạn thẻ"
        JLabel lblTitle = new JLabel("Gia Hạn Thẻ", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        contentPane.add(lblTitle, BorderLayout.NORTH);

        // Panel chứa các trường nhập liệu
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 2, 10, 10));
        contentPane.add(formPanel, BorderLayout.CENTER);

        // Mã thẻ
        JLabel lblMaThe = new JLabel("Mã Thẻ:");
        formPanel.add(lblMaThe);
        txtMaThe = new JTextField();
        txtMaThe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadDocGiaInfo();
            }
        });
        formPanel.add(txtMaThe);

        // Tên độc giả
        JLabel lblTenDocGia = new JLabel("Tên Độc Giả:");
        formPanel.add(lblTenDocGia);
        txtTenDocGia = new JTextField();
        txtTenDocGia.setEditable(false);
        formPanel.add(txtTenDocGia);

        // Ngày hết hạn hiện tại
        JLabel lblNgayHetHan = new JLabel("Ngày Hết Hạn Hiện Tại:");
        formPanel.add(lblNgayHetHan);
        try {
            MaskFormatter dateMask = new MaskFormatter("####-##-##");
            dateMask.setPlaceholderCharacter('_');
            txtNgayHetHan = new JFormattedTextField(dateMask);
            txtNgayHetHan.setEditable(false);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        formPanel.add(txtNgayHetHan);

        // Nút Gia Hạn và Hủy
        JButton btnGiaHan = new JButton("Gia Hạn");
        btnGiaHan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                extendCard();
            }
        });
        formPanel.add(btnGiaHan);

        JButton btnHuy = new JButton("Hủy");
        btnHuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Đóng form
            }
        });
        formPanel.add(btnHuy);
    }

    private void loadDocGiaInfo() {
        String maThe = txtMaThe.getText();
        try {
            DocGiaModel docGia = docGiaController.getDocGiaByMaThe(maThe);
            if (docGia != null) {
                txtTenDocGia.setText(docGia.getTenDG());
                txtNgayHetHan.setText(docGia.getNgayHetHan().toString());
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy thẻ với mã thẻ: " + maThe, "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra trong quá trình tải thông tin.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void extendCard() {
        String maThe = txtMaThe.getText();
        try {
            DocGiaModel docGia = docGiaController.getDocGiaByMaThe(maThe);
            if (docGia != null) {
                docGiaController.updateDocGia(docGia.getMaDG(), docGia.getTenDG(), docGia.getNgaySinh(), docGia.getDiaChiDG(), docGia.getDienThoai(), docGia.getMaThe());
                JOptionPane.showMessageDialog(this, "Gia hạn thẻ thành công!");
                txtNgayHetHan.setText(docGia.getNgayHetHan().toString());
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy thẻ với mã thẻ: " + maThe, "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra trong quá trình gia hạn.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
}
