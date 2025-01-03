package bookstore.view.Admin;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class QuanlyTacGia extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable tableTacGia;
    private JTextField txtMaTG, txtTenTG, txtDiaChiTG, textFieldSearch;
    private DefaultTableModel tableModel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    QuanlyTacGia frame = new QuanlyTacGia();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public QuanlyTacGia() {
        setTitle("Quản Lý Tác Giả");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        JLabel lblTitle = new JLabel("Quản Lý Tác Giả");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        headerPanel.add(lblTitle, BorderLayout.CENTER);
        contentPane.add(headerPanel, BorderLayout.NORTH);

        // Center panel with form and table
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        contentPane.add(centerPanel, BorderLayout.CENTER);

        // Form panel (for input fields)
        JPanel formPanel = new JPanel();
        formPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        centerPanel.add(formPanel, BorderLayout.NORTH);

        JLabel lblMaTG = new JLabel("Mã Tác Giả:");
        txtMaTG = new JTextField();

        JLabel lblTenTG = new JLabel("Tên Tác Giả:");
        txtTenTG = new JTextField();

        JLabel lblDiaChiTG = new JLabel("Địa Chỉ:");
        txtDiaChiTG = new JTextField();
        GroupLayout gl_formPanel = new GroupLayout(formPanel);
        gl_formPanel.setHorizontalGroup(
        	gl_formPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_formPanel.createSequentialGroup()
        			.addGroup(gl_formPanel.createParallelGroup(Alignment.TRAILING, false)
        				.addComponent(lblDiaChiTG, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addGroup(Alignment.LEADING, gl_formPanel.createParallelGroup(Alignment.TRAILING, false)
        					.addComponent(lblTenTG, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(lblMaTG, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_formPanel.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(txtDiaChiTG)
        				.addComponent(txtTenTG)
        				.addComponent(txtMaTG, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE))
        			.addGap(350))
        );
        gl_formPanel.setVerticalGroup(
        	gl_formPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_formPanel.createSequentialGroup()
        			.addGroup(gl_formPanel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblMaTG, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtMaTG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(10)
        			.addGroup(gl_formPanel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblTenTG, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtTenTG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(10)
        			.addGroup(gl_formPanel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblDiaChiTG, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtDiaChiTG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap())
        );
        formPanel.setLayout(gl_formPanel);

        // Table Panel
        JPanel tablePanel = new JPanel();
        centerPanel.add(tablePanel, BorderLayout.SOUTH);

        tableModel = new DefaultTableModel(
            new Object[][] {},
            new String[] { "Mã Tác Giả", "Tên Tác Giả", "Địa Chỉ" }
        );
        tableTacGia = new JTable(tableModel);
        tableTacGia.setRowHeight(30);
        tableTacGia.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(tableTacGia);
        
                // Footer panel (buttons)
                JPanel footerPanel = new JPanel();
                footerPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
                footerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
                
                        JButton btnThem = new JButton("Thêm");
                        btnThem.setFont(new Font("Arial", Font.BOLD, 14));
                        btnThem.setBackground(new Color(34, 139, 34));
                        btnThem.setForeground(Color.WHITE);
                        footerPanel.add(btnThem);
                        
                                JButton btnSua = new JButton("Sửa");
                                btnSua.setFont(new Font("Arial", Font.BOLD, 14));
                                btnSua.setBackground(new Color(255, 140, 0));
                                btnSua.setForeground(Color.WHITE);
                                footerPanel.add(btnSua);
                                
                                        JButton btnXoa = new JButton("Xóa");
                                        btnXoa.setFont(new Font("Arial", Font.BOLD, 14));
                                        btnXoa.setBackground(new Color(220, 20, 60));
                                        btnXoa.setForeground(Color.WHITE);
                                        footerPanel.add(btnXoa);
                                        
                                                // Back Button
                                                JButton btnBack = new JButton("Trở Về");
                                                btnBack.setFont(new Font("Arial", Font.BOLD, 14));
                                                btnBack.setBackground(new Color(70, 130, 180));
                                                btnBack.setForeground(Color.WHITE);
                                                footerPanel.add(btnBack);
                                                
                                                        // Search panel (added to centerPanel)
                                                        JPanel searchPanel = new JPanel();
                                                        footerPanel.add(searchPanel);
                                                        searchPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
                                                        searchPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
                                                        
                                                                JLabel lblSearch = new JLabel("Tìm kiếm: ");
                                                                lblSearch.setFont(new Font("Arial", Font.PLAIN, 14));
                                                                searchPanel.add(lblSearch);
                                                                
                                                                        textFieldSearch = new JTextField();
                                                                        textFieldSearch.setFont(new Font("Arial", Font.PLAIN, 14));
                                                                        textFieldSearch.setColumns(20);
                                                                        searchPanel.add(textFieldSearch);
                                                                        
                                                                                JButton btnSearch = new JButton("Tìm kiếm");
                                                                                btnSearch.setFont(new Font("Arial", Font.BOLD, 14));
                                                                                searchPanel.add(btnSearch);
                                                                                
                                                                                // Search button listener
                                                                                btnSearch.addActionListener(e -> searchRows(textFieldSearch.getText()));
                                                                                
                                                                                        // Add action listeners for buttons
                                                                                        btnThem.addActionListener(e -> addRow());
                                                                                        btnSua.addActionListener(e -> editRow());
                                                                                        btnXoa.addActionListener(e -> deleteRow());
                                                                                        btnBack.addActionListener(e -> goBack());
        GroupLayout gl_tablePanel = new GroupLayout(tablePanel);
        gl_tablePanel.setHorizontalGroup(
        	gl_tablePanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_tablePanel.createSequentialGroup()
        			.addGroup(gl_tablePanel.createParallelGroup(Alignment.LEADING)
        				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 804, GroupLayout.PREFERRED_SIZE)
        				.addComponent(footerPanel, GroupLayout.PREFERRED_SIZE, 814, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(20, Short.MAX_VALUE))
        );
        gl_tablePanel.setVerticalGroup(
        	gl_tablePanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_tablePanel.createSequentialGroup()
        			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(footerPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(71, Short.MAX_VALUE))
        );
        tablePanel.setLayout(gl_tablePanel);
    }

    // Method to add a row (to be implemented)
    private void addRow() {
        JOptionPane.showMessageDialog(this, "Chức năng Thêm chưa được triển khai.");
    }

    // Method to edit a selected row (to be implemented)
    private void editRow() {
        int selectedRow = tableTacGia.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa.");
            return;
        }
        JOptionPane.showMessageDialog(this, "Chức năng Sửa chưa được triển khai.");
    }

    // Method to delete a selected row
    private void deleteRow() {
        int selectedRow = tableTacGia.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xóa.");
            return;
        }
        tableModel.removeRow(selectedRow);
        JOptionPane.showMessageDialog(this, "Xóa thành công.");
    }

    // Method to search rows based on input
    private void searchRows(String keyword) {
        if (keyword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập từ khóa tìm kiếm.");
            return;
        }
        JOptionPane.showMessageDialog(this, "Chức năng Tìm kiếm chưa được triển khai.");
    }

    // Back button functionality (close current window)
    private void goBack() {
        this.dispose(); // Close the current window
    }
}
