package bookstore.view.Admin;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class QuanlyDocGia extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JTextField textFieldSearch;
    private DefaultTableModel tableModel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    QuanlyDocGia frame = new QuanlyDocGia();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
public QuanlyDocGia() {
    setTitle("Quản Lý Độc Giả");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 800, 627);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    contentPane.setLayout(new BorderLayout(0, 0));
    setContentPane(contentPane);

    // Header panel
    JPanel headerPanel = new JPanel();
    headerPanel.setLayout(new BorderLayout());
    headerPanel.setBackground(new Color(102, 153, 255));
    headerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
    JLabel lblTitle = new JLabel("Quản Lý Độc Giả");
    lblTitle.setForeground(Color.WHITE);
    lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
    lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
    headerPanel.add(lblTitle, BorderLayout.CENTER);
    contentPane.add(headerPanel, BorderLayout.NORTH);

    // Table panel
    JPanel tablePanel = new JPanel();

    tableModel = new DefaultTableModel(
        new Object[][] {},
        new String[] { "Mã Độc Giả", "Tên Độc Giả", "Địa Chỉ", "Ngày Sinh", "Điện Thoại", "Mã Thẻ", "Ngày Hết Hạn" }
    );
    table = new JTable(tableModel);
    table.setRowHeight(30);
    table.setFont(new Font("Arial", Font.PLAIN, 14));
    JScrollPane scrollPane = new JScrollPane(table);
    contentPane.add(tablePanel, BorderLayout.CENTER);
    
        // Panel for form input fields
        JPanel formPanel = new JPanel();
        formPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        JLabel lblMaDocGia = new JLabel("Mã Độc Giả:");
        JTextField txtMaDocGia = new JTextField();
        
        JLabel lblTenDocGia = new JLabel("Tên Độc Giả:");
        JTextField txtTenDocGia = new JTextField();
        
        JLabel lblDiaChi = new JLabel("Địa Chỉ:");
        JTextField txtDiaChi = new JTextField();
        
        JLabel lblNgaySinh = new JLabel("Ngày Sinh:");
        JTextField txtNgaySinh = new JTextField();
        
        JLabel lblDienThoai = new JLabel("Điện Thoại:");
        JTextField txtDienThoai = new JTextField();
        
        JLabel lblMaThe = new JLabel("Mã Thẻ:");
        JTextField txtMaThe = new JTextField();
        
        JLabel lblNgayHetHan = new JLabel("Ngày Hết Hạn:");
        JTextField txtNgayHetHan = new JTextField();
        GroupLayout gl_formPanel = new GroupLayout(formPanel);
        gl_formPanel.setHorizontalGroup(
        	gl_formPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_formPanel.createSequentialGroup()
        			.addGap(1)
        			.addGroup(gl_formPanel.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(lblMaDocGia, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(lblDiaChi, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(lblDienThoai, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(lblNgayHetHan, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_formPanel.createParallelGroup(Alignment.LEADING)
        				.addComponent(txtNgayHetHan, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
        				.addGroup(Alignment.TRAILING, gl_formPanel.createSequentialGroup()
        					.addGroup(gl_formPanel.createParallelGroup(Alignment.LEADING)
        						.addComponent(txtMaDocGia, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
        						.addComponent(txtDiaChi, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
        						.addComponent(txtDienThoai, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
        					.addGroup(gl_formPanel.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblTenDocGia, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
        						.addGroup(gl_formPanel.createParallelGroup(Alignment.TRAILING, false)
        							.addComponent(lblNgaySinh, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addComponent(lblMaThe, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(gl_formPanel.createParallelGroup(Alignment.LEADING)
        						.addComponent(txtNgaySinh, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
        						.addComponent(txtTenDocGia, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
        						.addComponent(txtMaThe, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
        					.addGap(141))))
        );
        gl_formPanel.setVerticalGroup(
        	gl_formPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_formPanel.createSequentialGroup()
        			.addGroup(gl_formPanel.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_formPanel.createParallelGroup(Alignment.BASELINE)
        					.addComponent(lblTenDocGia, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
        					.addComponent(txtTenDocGia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_formPanel.createParallelGroup(Alignment.BASELINE)
        					.addComponent(lblMaDocGia, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
        					.addComponent(txtMaDocGia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addGap(10)
        			.addGroup(gl_formPanel.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_formPanel.createParallelGroup(Alignment.BASELINE)
        					.addComponent(lblDiaChi, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
        					.addComponent(txtDiaChi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_formPanel.createParallelGroup(Alignment.BASELINE)
        					.addComponent(lblNgaySinh, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
        					.addComponent(txtNgaySinh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addGap(10)
        			.addGroup(gl_formPanel.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_formPanel.createSequentialGroup()
        					.addGroup(gl_formPanel.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblDienThoai, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
        						.addComponent(txtDienThoai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(10)
        					.addGroup(gl_formPanel.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblNgayHetHan, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
        						.addComponent(txtNgayHetHan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(gl_formPanel.createParallelGroup(Alignment.BASELINE)
        					.addComponent(lblMaThe, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
        					.addComponent(txtMaThe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        formPanel.setLayout(gl_formPanel);
    GroupLayout gl_tablePanel = new GroupLayout(tablePanel);
    gl_tablePanel.setHorizontalGroup(
    	gl_tablePanel.createParallelGroup(Alignment.LEADING)
    		.addGroup(gl_tablePanel.createSequentialGroup()
    			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 776, GroupLayout.PREFERRED_SIZE)
    			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    		.addGroup(Alignment.TRAILING, gl_tablePanel.createSequentialGroup()
    			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    			.addComponent(formPanel, GroupLayout.PREFERRED_SIZE, 786, GroupLayout.PREFERRED_SIZE)
    			.addContainerGap())
    );
    gl_tablePanel.setVerticalGroup(
    	gl_tablePanel.createParallelGroup(Alignment.LEADING)
    		.addGroup(gl_tablePanel.createSequentialGroup()
    			.addContainerGap()
    			.addComponent(formPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    			.addPreferredGap(ComponentPlacement.UNRELATED)
    			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
    			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    tablePanel.setLayout(gl_tablePanel);

    // Footer panel (actions and search)
    JPanel footerPanel = new JPanel();
    footerPanel.setLayout(new BorderLayout());
    footerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

    // Action buttons panel
    JPanel actionPanel = new JPanel();
    actionPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));

    JButton btnAdd = new JButton("Thêm");
    btnAdd.setFont(new Font("Arial", Font.BOLD, 14));
    btnAdd.setBackground(new Color(34, 139, 34));
    btnAdd.setForeground(Color.WHITE);
    actionPanel.add(btnAdd);

    JButton btnEdit = new JButton("Sửa");
    btnEdit.setFont(new Font("Arial", Font.BOLD, 14));
    btnEdit.setBackground(new Color(255, 140, 0));
    btnEdit.setForeground(Color.WHITE);
    actionPanel.add(btnEdit);

    JButton btnDelete = new JButton("Xóa");
    btnDelete.setFont(new Font("Arial", Font.BOLD, 14));
    btnDelete.setBackground(new Color(220, 20, 60));
    btnDelete.setForeground(Color.WHITE);
    actionPanel.add(btnDelete);

    footerPanel.add(actionPanel, BorderLayout.WEST);

    // Search panel
    JPanel searchPanel = new JPanel();
    searchPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 0));

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

    footerPanel.add(searchPanel, BorderLayout.EAST);

    contentPane.add(footerPanel, BorderLayout.SOUTH);

    // Add action listeners for buttons
    btnAdd.addActionListener(e -> addRow());
    btnEdit.addActionListener(e -> editRow());
    btnDelete.addActionListener(e -> deleteRow());
    btnSearch.addActionListener(e -> searchRows(textFieldSearch.getText()));
}


    /**
     * Method to add a row (to be implemented)
     */
    private void addRow() {
        JOptionPane.showMessageDialog(this, "Chức năng Thêm chưa được triển khai.");
    }

    /**
     * Method to edit a selected row (to be implemented)
     */
    private void editRow() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa.");
            return;
        }
        JOptionPane.showMessageDialog(this, "Chức năng Sửa chưa được triển khai.");
    }

    /**
     * Method to delete a selected row
     */
    private void deleteRow() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xóa.");
            return;
        }
        tableModel.removeRow(selectedRow);
        JOptionPane.showMessageDialog(this, "Xóa thành công.");
    }

    /**
     * Method to search rows based on input
     */
    private void searchRows(String keyword) {
        if (keyword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập từ khóa tìm kiếm.");
            return;
        }
        JOptionPane.showMessageDialog(this, "Chức năng Tìm kiếm chưa được triển khai.");
    }

    /**
     * Method to populate table with data (to be connected with database)
     */
    public void loadData(List<Object[]> data) {
        tableModel.setRowCount(0);
        for (Object[] row : data) {
            tableModel.addRow(row);
        }
    }
}
