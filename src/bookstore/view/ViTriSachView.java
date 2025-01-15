package bookstore.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import bookstore.controller.ViTriSachController;
import bookstore.model.ViTriModel;
import bookstore.share.MenuBarAdmin;

public class ViTriSachView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable tableViTriSach;
    private JTextField txtKhu, txtKe, txtNgan, textFieldSearch;
    private DefaultTableModel tableModel;
    private ViTriSachController viTriSachController;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViTriSachView frame = new ViTriSachView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ViTriSachView() {
        viTriSachController = new ViTriSachController(); // Initialize controller

        setTitle("Quản Lý Vị Trí Sách");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        // Header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBackground(new Color(102, 153, 255));
        headerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        JLabel lblTitle = new JLabel("Quản Lý Vị Trí Sách");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        headerPanel.add(lblTitle, BorderLayout.CENTER);
        contentPane.add(headerPanel, BorderLayout.NORTH);
        // Center panel with form and table
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        contentPane.add(centerPanel, BorderLayout.CENTER);
        
     // Tích hợp MenuBarAdmin
     		MenuBarAdmin menuBarAdmin = new MenuBarAdmin();
     		setJMenuBar(menuBarAdmin);

        // Form panel (for input fields)
        JPanel formPanel = new JPanel();
        formPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        centerPanel.add(formPanel, BorderLayout.NORTH);

        JLabel lblKhu = new JLabel("Khu:");
        txtKhu = new JTextField();

        JLabel lblKe = new JLabel("Kệ:");
        txtKe = new JTextField();

        JLabel lblNgan = new JLabel("Ngăn:");
        txtNgan = new JTextField();
        GroupLayout gl_formPanel = new GroupLayout(formPanel);
        gl_formPanel.setHorizontalGroup(gl_formPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_formPanel
                .createSequentialGroup()
                .addGroup(gl_formPanel.createParallelGroup(Alignment.TRAILING, false)
                        .addComponent(lblNgan, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(Alignment.LEADING, gl_formPanel.createParallelGroup(Alignment.TRAILING, false)
                                .addComponent(lblKe, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblKhu, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 96,
                                        Short.MAX_VALUE)))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(gl_formPanel.createParallelGroup(Alignment.LEADING, false).addComponent(txtNgan)
                        .addComponent(txtKe)
                        .addComponent(txtKhu, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE))
                .addGap(350)));
        gl_formPanel.setVerticalGroup(gl_formPanel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_formPanel.createSequentialGroup()
                        .addGroup(gl_formPanel.createParallelGroup(Alignment.BASELINE)
                                .addComponent(lblKhu, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtKhu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE))
                        .addGap(10)
                        .addGroup(gl_formPanel.createParallelGroup(Alignment.BASELINE)
                                .addComponent(lblKe, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtKe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE))
                        .addGap(10)
                        .addGroup(gl_formPanel.createParallelGroup(Alignment.BASELINE)
                                .addComponent(lblNgan, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNgan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE))
                        .addContainerGap()));
        formPanel.setLayout(gl_formPanel);
        // Table Panel
        JPanel tablePanel = new JPanel();
        centerPanel.add(tablePanel, BorderLayout.CENTER);

        // Create DefaultTableModel with column names for ViTriSach table
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Mã Vị Trí");
        tableModel.addColumn("Khu");
        tableModel.addColumn("Kệ");
        tableModel.addColumn("Ngăn");

        tableViTriSach = new JTable(tableModel);
        tableViTriSach.setRowHeight(30);
        tableViTriSach.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(tableViTriSach);

        // Footer panel (buttons)
        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        footerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JButton addButton = new JButton("Thêm");
        addButton.setFont(new Font("Arial", Font.BOLD, 14));
        addButton.setBackground(new Color(0, 123, 255));
        addButton.setForeground(Color.WHITE);
        footerPanel.add(addButton);

        JButton editButton = new JButton("Sửa");
        editButton.setFont(new Font("Arial", Font.BOLD, 14));
        editButton.setBackground(new Color(255, 165, 0));
        editButton.setForeground(Color.WHITE);
        footerPanel.add(editButton);

        JButton deleteButton = new JButton("Xóa");
        deleteButton.setFont(new Font("Arial", Font.BOLD, 14));
        deleteButton.setBackground(new Color(220, 53, 69));
        deleteButton.setForeground(Color.WHITE);
        footerPanel.add(deleteButton);

        JButton saveButton = new JButton("Lưu");
        saveButton.setFont(new Font("Arial", Font.BOLD, 14));
        saveButton.setBackground(new Color(34, 139, 34));
        saveButton.setForeground(Color.WHITE);
        footerPanel.add(saveButton);

        // Add Action Listeners for buttons
        addButton.addActionListener(e -> addRow());
        editButton.addActionListener(e -> editRow());
        deleteButton.addActionListener(e -> deleteRow());
        saveButton.addActionListener(e -> saveData());

        // Add MouseListener to table for row selection
        tableViTriSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displaySelectedRow();
            }
        });

        tablePanel.setLayout(new BorderLayout());
        tablePanel.add(scrollPane, BorderLayout.CENTER);
        contentPane.add(footerPanel, BorderLayout.SOUTH);
    }

    // Populate JTable with data from the database
    private void populateViTriTable() {
        viTriSachController.populateViTriTable(tableViTriSach);
    }

    // Method to add a row
    private void addRow() {
        // Lấy dữ liệu từ các trường nhập liệu
        String khu = txtKhu.getText().trim();
        String ke = txtKe.getText().trim();
        String ngan = txtNgan.getText().trim();

        // Kiểm tra dữ liệu đầu vào
        if (khu.isEmpty() || ke.isEmpty() || ngan.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin vị trí.");
            return;
        }

        boolean isAdded = viTriSachController.addViTri(khu, ke, ngan);
        if (isAdded) {
            JOptionPane.showMessageDialog(this, "Thêm vị trí thành công.");
            populateViTriTable();
            clearTextFields();
        } else {
            JOptionPane.showMessageDialog(this, "Có lỗi trong quá trình thêm vị trí.");
        }
    }

    // Method to edit a selected row
    private void editRow() {
        int selectedRow = tableViTriSach.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa.");
            return;
        }

        String maVTStr = tableModel.getValueAt(selectedRow, 0).toString();
        int maVT = Integer.parseInt(maVTStr);
        String khu = txtKhu.getText().trim();
        String ke = txtKe.getText().trim();
        String ngan = txtNgan.getText().trim();

        if (khu.isEmpty() || ke.isEmpty() || ngan.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin vị trí.");
            return;
        }

        boolean isUpdated = viTriSachController.updateViTri(maVT, khu, ke, ngan);
        if (isUpdated) {
            JOptionPane.showMessageDialog(this, "Sửa vị trí thành công.");
            populateViTriTable();
            clearTextFields();
        } else {
            JOptionPane.showMessageDialog(this, "Có lỗi trong quá trình sửa vị trí.");
        }
    }

    // Method to delete a selected row
    private void deleteRow() {
        int selectedRow = tableViTriSach.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xóa.");
            return;
        }

        String maVTStr = tableModel.getValueAt(selectedRow, 0).toString();
        int maVT = Integer.parseInt(maVTStr);

        boolean isDeleted = viTriSachController.deleteViTri(maVT);
        if (isDeleted) {
            JOptionPane.showMessageDialog(this, "Xóa vị trí thành công.");
            populateViTriTable();
            clearTextFields();
        } else {
            JOptionPane.showMessageDialog(this, "Có lỗi trong quá trình xóa.");
        }
    }

    // Method to display selected row's data in text fields
    private void displaySelectedRow() {
        int selectedRow = tableViTriSach.getSelectedRow();
        if (selectedRow != -1) {
            txtKhu.setText(tableModel.getValueAt(selectedRow, 1).toString());
            txtKe.setText(tableModel.getValueAt(selectedRow, 2).toString());
            txtNgan.setText(tableModel.getValueAt(selectedRow, 3).toString());
        }
    }

    // Method to clear text fields
    private void clearTextFields() {
        txtKhu.setText("");
        txtKe.setText("");
        txtNgan.setText("");
    }

    // Method to save data (if needed, this is just a placeholder)
    private void saveData() {
        // Logic for saving the location data
        JOptionPane.showMessageDialog(this, "Lưu dữ liệu thành công.");
    }
}
