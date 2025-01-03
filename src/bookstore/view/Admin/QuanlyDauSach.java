package bookstore.view.Admin;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class QuanlyDauSach extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JTextField textFieldSearch, textFieldMaSach, textFieldTuaSach, textFieldTomTat, textFieldSoLuong, textFieldMaNgonNgu, textFieldMaViTri;
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

        tableModel = new DefaultTableModel(
            new Object[][] {},
            new String[] { "Mã Sách", "Tựa Sách", "Tóm Tắt", "Số Lượng", "Mã Ngôn Ngữ", "Mã Vị Trí" }
        );
        table = new JTable(tableModel);
        table.setRowHeight(30);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(table);
        contentPane.add(tablePanel, BorderLayout.CENTER);
        
                // Input Fields Panel (for "Mã Sách", "Tựa Sách", etc.)
                JPanel inputFieldsPanel = new JPanel();
                
                        JLabel lblMaSach = new JLabel("Mã Sách:");
                        lblMaSach.setFont(new Font("Arial", Font.PLAIN, 14));
                        
                                textFieldMaSach = new JTextField();
                                textFieldMaSach.setFont(new Font("Arial", Font.PLAIN, 14));
                                
                                        JLabel lblTuaSach = new JLabel("Tựa Sách:");
                                        lblTuaSach.setFont(new Font("Arial", Font.PLAIN, 14));
                                        
                                                textFieldTuaSach = new JTextField();
                                                textFieldTuaSach.setFont(new Font("Arial", Font.PLAIN, 14));
                                                
                                                        JLabel lblTomTat = new JLabel("Tóm Tắt:");
                                                        lblTomTat.setFont(new Font("Arial", Font.PLAIN, 14));
                                                        
                                                                textFieldTomTat = new JTextField();
                                                                textFieldTomTat.setFont(new Font("Arial", Font.PLAIN, 14));
                                                                
                                                                        JLabel lblSoLuong = new JLabel("Số Lượng:");
                                                                        lblSoLuong.setFont(new Font("Arial", Font.PLAIN, 14));
                                                                        
                                                                                textFieldSoLuong = new JTextField();
                                                                                textFieldSoLuong.setFont(new Font("Arial", Font.PLAIN, 14));
                                                                                
                                                                                        JLabel lblMaNgonNgu = new JLabel("Mã Ngôn Ngữ:");
                                                                                        lblMaNgonNgu.setFont(new Font("Arial", Font.PLAIN, 14));
                                                                                        
                                                                                                textFieldMaNgonNgu = new JTextField();
                                                                                                textFieldMaNgonNgu.setFont(new Font("Arial", Font.PLAIN, 14));
                                                                                                
                                                                                                        JLabel lblMaViTri = new JLabel("Mã Vị Trí:");
                                                                                                        lblMaViTri.setFont(new Font("Arial", Font.PLAIN, 14));
                                                                                                        
                                                                                                                textFieldMaViTri = new JTextField();
                                                                                                                textFieldMaViTri.setFont(new Font("Arial", Font.PLAIN, 14));
        GroupLayout gl_tablePanel = new GroupLayout(tablePanel);
        gl_tablePanel.setHorizontalGroup(
        	gl_tablePanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_tablePanel.createSequentialGroup()
        			.addGroup(gl_tablePanel.createParallelGroup(Alignment.LEADING)
        				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 776, GroupLayout.PREFERRED_SIZE)
        				.addComponent(inputFieldsPanel, GroupLayout.PREFERRED_SIZE, 786, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_tablePanel.setVerticalGroup(
        	gl_tablePanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_tablePanel.createSequentialGroup()
        			.addComponent(inputFieldsPanel, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(34, Short.MAX_VALUE))
        );
        GroupLayout gl_inputFieldsPanel = new GroupLayout(inputFieldsPanel);
        gl_inputFieldsPanel.setHorizontalGroup(
        	gl_inputFieldsPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_inputFieldsPanel.createSequentialGroup()
        			.addGap(45)
        			.addGroup(gl_inputFieldsPanel.createParallelGroup(Alignment.TRAILING, false)
        				.addComponent(lblMaSach, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(lblMaNgonNgu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(lblTomTat, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
        			.addGap(4)
        			.addGroup(gl_inputFieldsPanel.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_inputFieldsPanel.createSequentialGroup()
        					.addComponent(textFieldMaNgonNgu, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, 396, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_inputFieldsPanel.createSequentialGroup()
        					.addGroup(gl_inputFieldsPanel.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_inputFieldsPanel.createSequentialGroup()
        							.addComponent(textFieldTomTat, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
        							.addGap(89)
        							.addGroup(gl_inputFieldsPanel.createParallelGroup(Alignment.LEADING)
        								.addGroup(gl_inputFieldsPanel.createSequentialGroup()
        									.addGap(12)
        									.addComponent(lblMaViTri, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
        								.addGroup(gl_inputFieldsPanel.createSequentialGroup()
        									.addGap(10)
        									.addGroup(gl_inputFieldsPanel.createParallelGroup(Alignment.LEADING)
        										.addComponent(lblTuaSach, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
        										.addComponent(lblSoLuong, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)))))
        						.addGroup(gl_inputFieldsPanel.createSequentialGroup()
        							.addComponent(textFieldMaSach, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
        							.addGap(197)))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(gl_inputFieldsPanel.createParallelGroup(Alignment.LEADING)
        						.addComponent(textFieldMaViTri, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
        						.addComponent(textFieldSoLuong, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
        						.addComponent(textFieldTuaSach, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))))
        			.addGap(56))
        );
        gl_inputFieldsPanel.setVerticalGroup(
        	gl_inputFieldsPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, gl_inputFieldsPanel.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGroup(gl_inputFieldsPanel.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_inputFieldsPanel.createParallelGroup(Alignment.BASELINE)
        					.addComponent(textFieldTuaSach, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addComponent(lblTuaSach, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_inputFieldsPanel.createParallelGroup(Alignment.BASELINE)
        					.addComponent(lblMaSach, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        					.addComponent(textFieldMaSach, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addGap(10)
        			.addGroup(gl_inputFieldsPanel.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_inputFieldsPanel.createSequentialGroup()
        					.addGroup(gl_inputFieldsPanel.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_inputFieldsPanel.createSequentialGroup()
        							.addGroup(gl_inputFieldsPanel.createParallelGroup(Alignment.BASELINE)
        								.addComponent(lblSoLuong, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        								.addComponent(textFieldSoLuong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        							.addGap(10)
        							.addGroup(gl_inputFieldsPanel.createParallelGroup(Alignment.BASELINE)
        								.addComponent(lblMaViTri, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        								.addComponent(textFieldMaViTri, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        						.addComponent(lblTomTat, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(gl_inputFieldsPanel.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblMaNgonNgu, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        						.addComponent(textFieldMaNgonNgu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        				.addComponent(textFieldTomTat, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap())
        );
        inputFieldsPanel.setLayout(gl_inputFieldsPanel);
        tablePanel.setLayout(gl_tablePanel);

        // Footer panel (actions and buttons)
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
    }
}
