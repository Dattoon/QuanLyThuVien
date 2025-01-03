package bookstore.view.Admin;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.List;

public class QuanlyDauSach extends JFrame {

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
                    QuanlyDauSach frame = new QuanlyDauSach();
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
    public QuanlyDauSach() {
        setTitle("Quản Lý Đầu Sách");
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
        JLabel lblTitle = new JLabel("Quản Lý Đầu Sách");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        headerPanel.add(lblTitle, BorderLayout.CENTER);
        contentPane.add(headerPanel, BorderLayout.NORTH);

        // Table panel
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(
            new Object[][] {},
            new String[] { "Mã Sách", "Tựa Sách", "Tóm Tắt", "Số Lượng", "Mã Ngôn Ngữ", "Mã Vị Trí" }
        );
        table = new JTable(tableModel);
        table.setRowHeight(30);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(table);
        tablePanel.add(scrollPane, BorderLayout.NORTH);
        contentPane.add(tablePanel, BorderLayout.CENTER);

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
