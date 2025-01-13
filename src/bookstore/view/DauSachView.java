package bookstore.view;

import bookstore.controller.DauSachController;
import bookstore.model.DauSachModel;
import bookstore.model.TacGiaModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DauSachView extends JFrame {
    private DauSachController controller;

    private JTable table;
    private DefaultTableModel tableModel;

    private JTextField txtTuaSach;
    private JTextArea txtTomTat;
    private JTextField txtSoLuong;
    private JComboBox<String> cbNgonNgu;
    private JComboBox<String> cbViTri;
    private JList<String> listTacGia;

    private JButton btnAdd;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnClear;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	DauSachView frame = new DauSachView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public DauSachView() {
        controller = new DauSachController();
        initComponents();
        loadData();
    }

    private void initComponents() {
        setTitle("Quản Lý Đầu Sách");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        // Table
        tableModel = new DefaultTableModel(new String[]{"Mã", "Tựa Sách", "Tóm Tắt", "Số Lượng", "Ngôn Ngữ", "Vị Trí"}, 0);
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getSelectionModel().addListSelectionListener(e -> displaySelectedRow());
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        // Form input
        JPanel inputPanel = new JPanel(new GridLayout(7, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(new JLabel("Tựa Sách:"));
        txtTuaSach = new JTextField();
        inputPanel.add(txtTuaSach);

        inputPanel.add(new JLabel("Tóm Tắt:"));
        txtTomTat = new JTextArea(3, 20);
        inputPanel.add(new JScrollPane(txtTomTat));

        inputPanel.add(new JLabel("Số Lượng:"));
        txtSoLuong = new JTextField();
        inputPanel.add(txtSoLuong);

        inputPanel.add(new JLabel("Ngôn Ngữ:"));
        cbNgonNgu = new JComboBox<>();
        inputPanel.add(cbNgonNgu);

        inputPanel.add(new JLabel("Vị Trí:"));
        cbViTri = new JComboBox<>();
        inputPanel.add(cbViTri);

        inputPanel.add(new JLabel("Tác Giả:"));
        listTacGia = new JList<>();
        inputPanel.add(new JScrollPane(listTacGia));

        panel.add(inputPanel, BorderLayout.EAST);

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        btnAdd = new JButton("Thêm");
        btnUpdate = new JButton("Cập Nhật");
        btnDelete = new JButton("Xóa");
        btnClear = new JButton("Làm Mới");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnClear);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        setContentPane(panel);

        // Events
        btnAdd.addActionListener(e -> addDauSach());
        btnUpdate.addActionListener(e -> updateDauSach());
        btnDelete.addActionListener(e -> deleteDauSach());
        btnClear.addActionListener(e -> clearForm());
    }

    private void loadData() {
        try {
            // Load table data
            List<DauSachModel> dauSachList = controller.getAllDauSach();
            tableModel.setRowCount(0); // Xóa toàn bộ dữ liệu hiện có trong bảng
            if (dauSachList != null && !dauSachList.isEmpty()) {
                for (DauSachModel ds : dauSachList) {
                    tableModel.addRow(new Object[]{
                            ds.getMaSach(),
                            ds.getTuaSach(),
                            ds.getTomTat(),
                            ds.getSl(),
                            controller.getTenNgonNgu(ds.getMaNN()),
                            controller.getTenViTri(ds.getMaVT())
                    });
                }
            } else {
                JOptionPane.showMessageDialog(this, "Không có dữ liệu đầu sách!", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            }

            // Load combobox Ngôn Ngữ
            cbNgonNgu.removeAllItems();
            List<String> ngonNguList = controller.getAllNgonNguNames();
            if (ngonNguList != null && !ngonNguList.isEmpty()) {
                for (String nn : ngonNguList) {
                    cbNgonNgu.addItem(nn);
                }
            } else {
                cbNgonNgu.addItem("Không có dữ liệu");
            }

            // Load combobox Vị Trí
            cbViTri.removeAllItems();
            List<String> viTriList = controller.getAllViTri();
            if (viTriList != null && !viTriList.isEmpty()) {
                for (String vt : viTriList) {
                    cbViTri.addItem(vt);
                }
            } else {
                cbViTri.addItem("Không có dữ liệu");
            }

            // Load list Tác Giả
            DefaultListModel<String> listModel = new DefaultListModel<>();
            List<String> tacGiaList = controller.getAllTacGiaNames();
            if (tacGiaList != null && !tacGiaList.isEmpty()) {
                for (String tg : tacGiaList) {
                    listModel.addElement(tg);
                }
            } else {
                listModel.addElement("Không có dữ liệu");
            }
            listTacGia.setModel(listModel);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi tải dữ liệu: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    
  private void displaySelectedRow() {
    int selectedRow = table.getSelectedRow();
    if (selectedRow != -1) {
        txtTuaSach.setText(tableModel.getValueAt(selectedRow, 1).toString());
        txtTomTat.setText(tableModel.getValueAt(selectedRow, 2).toString());
        txtSoLuong.setText(tableModel.getValueAt(selectedRow, 3).toString());
        cbNgonNgu.setSelectedItem(tableModel.getValueAt(selectedRow, 4).toString());
        cbViTri.setSelectedItem(tableModel.getValueAt(selectedRow, 5).toString());

        // Lấy mã sách từ bảng
        int maSach = Integer.parseInt(tableModel.getValueAt(selectedRow, 0).toString());
        List<TacGiaModel> tacGiaModels = controller.getTacGiaByDauSachId(maSach);

        // Danh sách tên tác giả được chọn
        List<String> selectedTacGia = tacGiaModels.stream()
                .map(TacGiaModel::getTenTG)
                .toList();

        // Tìm các chỉ số của tác giả trong danh sách hiện tại
        DefaultListModel<String> listModel = (DefaultListModel<String>) listTacGia.getModel();
        List<String> allTacGia = new ArrayList<>();
        for (int i = 0; i < listModel.size(); i++) {
            allTacGia.add(listModel.get(i));
        }

        // Chọn tác giả
        int[] indices = selectedTacGia.stream()
                .mapToInt(allTacGia::indexOf)
                .filter(index -> index >= 0)
                .toArray();

        listTacGia.setSelectedIndices(indices);
    }
}

  private void addDauSach() {
	    try {
	        String tuaSach = txtTuaSach.getText().trim();
	        String tomTat = txtTomTat.getText().trim();
	        int soLuong = Integer.parseInt(txtSoLuong.getText().trim());
	        int maNN = cbNgonNgu.getSelectedIndex() + 1;
	        int maVT = cbViTri.getSelectedIndex() + 1;

	        if (tuaSach.isEmpty() || tomTat.isEmpty() || soLuong <= 0) {
	            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin và số lượng > 0!");
	            return;
	        }

	        List<Integer> maTacGiaList = listTacGia.getSelectedValuesList().stream()
	                .map(name -> controller.getAllTacGiaNames().indexOf(name) + 1)
	                .toList();

	        if (controller.addDauSach(tuaSach, tomTat, soLuong, maNN, maVT, maTacGiaList) > 0) {
	            JOptionPane.showMessageDialog(this, "Thêm đầu sách thành công!");
	            loadData();
	            clearForm();
	        } else {
	            JOptionPane.showMessageDialog(this, "Thêm đầu sách thất bại!");
	        }
	    } catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(this, "Số lượng phải là số nguyên hợp lệ!");
	    }
	}

  private void updateDauSach() {
	    int selectedRow = table.getSelectedRow();
	    if (selectedRow == -1) {
	        JOptionPane.showMessageDialog(this, "Vui lòng chọn một đầu sách để cập nhật.");
	        return;
	    }

	    try {
	        int maSach = Integer.parseInt(tableModel.getValueAt(selectedRow, 0).toString());
	        String tuaSach = txtTuaSach.getText().trim();
	        String tomTat = txtTomTat.getText().trim();
	        int soLuong = Integer.parseInt(txtSoLuong.getText().trim());
	        int maNN = cbNgonNgu.getSelectedIndex() + 1;
	        int maVT = cbViTri.getSelectedIndex() + 1;

	        if (tuaSach.isEmpty() || tomTat.isEmpty() || soLuong <= 0) {
	            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin và số lượng > 0!");
	            return;
	        }

	        List<Integer> maTacGiaList = listTacGia.getSelectedValuesList().stream()
	                .map(name -> controller.getAllTacGiaNames().indexOf(name) + 1)
	                .toList();

	        if (controller.updateDauSach(maSach, tuaSach, tomTat, soLuong, maNN, maVT, maTacGiaList)) {
	            JOptionPane.showMessageDialog(this, "Cập nhật đầu sách thành công!");
	            loadData();
	        } else {
	            JOptionPane.showMessageDialog(this, "Cập nhật đầu sách thất bại!");
	        }
	    } catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(this, "Số lượng phải là số nguyên hợp lệ!");
	    }
	}

    private void deleteDauSach() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một đầu sách để xóa.");
            return;
        }

        int maSach = Integer.parseInt(tableModel.getValueAt(selectedRow, 0).toString());
        controller.deleteDauSach(maSach);
        loadData();
    }

    private void clearForm() {
        txtTuaSach.setText("");
        txtTomTat.setText("");
        txtSoLuong.setText("");
        cbNgonNgu.setSelectedIndex(-1);
        cbViTri.setSelectedIndex(-1);
        listTacGia.clearSelection();
    }

   

	private int getNextMatch(String string1) {
		return 0;
	}
}
