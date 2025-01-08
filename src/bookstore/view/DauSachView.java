package bookstore.view;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import bookstore.controller.DauSachController;
import bookstore.controller.NgonNguController;
import bookstore.controller.ViTriSachController;
import bookstore.controller.TacGiaController;
import bookstore.model.TacGiaModel;

public class DauSachView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable tableDauSach;
    private JTextField txtMaSach, txtTuaSach, txtTomTat, txtSL;
    private JComboBox<String> comboBoxNgonNgu, comboBoxViTri;
    private DefaultTableModel tableModel;
    private DauSachController dauSachController;
    private NgonNguController ngonNguController;
    private ViTriSachController viTriSachController;
    private TacGiaController tacGiaController;
    private JList<String> listTacGia;
    private DefaultListModel<String> listModelTacGia;
    private JList<String> listSelectedTacGia;
    private DefaultListModel<String> listModelSelectedTacGia;

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
        dauSachController = new DauSachController();
        ngonNguController = new NgonNguController();
        viTriSachController = new ViTriSachController();
        tacGiaController = new TacGiaController();

        setTitle("Quản Lý Sách");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        // Header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBackground(new Color(102, 153, 255));
        headerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        JLabel lblTitle = new JLabel("Quản Lý Sách");
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

        JLabel lblMaSach = new JLabel("Mã Sách:");
        txtMaSach = new JTextField();
        txtMaSach.setEditable(false); // Disable editing for MaSach field since it will be auto-incremented by DB

        JLabel lblTuaSach = new JLabel("Tựa Sách:");
        txtTuaSach = new JTextField();
        txtTuaSach.setColumns(10);

        JLabel lblTomTat = new JLabel("Tóm Tắt:");
        txtTomTat = new JTextField();
        txtTomTat.setColumns(10);

        JLabel lblSL = new JLabel("Số Lượng:");
        txtSL = new JTextField();
        txtSL.setColumns(10);

        JLabel lblNgonNgu = new JLabel("Ngôn Ngữ:");
        comboBoxNgonNgu = new JComboBox<>();

        JLabel lblViTri = new JLabel("Vị Trí:");
        comboBoxViTri = new JComboBox<>();

        GroupLayout gl_formPanel = new GroupLayout(formPanel);
        gl_formPanel.setHorizontalGroup(
            gl_formPanel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_formPanel.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(gl_formPanel.createParallelGroup(Alignment.LEADING, false)
                        .addComponent(lblMaSach, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTuaSach, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTomTat, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNgonNgu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblViTri, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(gl_formPanel.createParallelGroup(Alignment.LEADING)
                        .addComponent(txtMaSach)
                        .addComponent(txtTuaSach)
                        .addComponent(txtTomTat)
                        .addComponent(txtSL)
                        .addComponent(comboBoxNgonNgu, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboBoxViTri, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
        );
        gl_formPanel.setVerticalGroup(
            gl_formPanel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_formPanel.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(gl_formPanel.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblMaSach)
                        .addComponent(txtMaSach, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addGroup(gl_formPanel.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblTuaSach)
                        .addComponent(txtTuaSach, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addGroup(gl_formPanel.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblTomTat)
                        .addComponent(txtTomTat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addGroup(gl_formPanel.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblSL)
                        .addComponent(txtSL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addGroup(gl_formPanel.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblNgonNgu)
                        .addComponent(comboBoxNgonNgu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addGroup(gl_formPanel.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblViTri)
                        .addComponent(comboBoxViTri, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        formPanel.setLayout(gl_formPanel);
        // Table Panel
        JPanel tablePanel = new JPanel();
        centerPanel.add(tablePanel, BorderLayout.CENTER);

        // Create DefaultTableModel with column names for DauSach table
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Mã Sách");
        tableModel.addColumn("Tựa Sách");
        tableModel.addColumn("Tóm Tắt");
        tableModel.addColumn("Số Lượng");
        tableModel.addColumn("Mã Ngôn Ngữ");
        tableModel.addColumn("Mã Vị Trí");

        tableDauSach = new JTable(tableModel);
        tableDauSach.setRowHeight(30);
        tableDauSach.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(tableDauSach);

        tablePanel.setLayout(new BorderLayout());
        tablePanel.add(scrollPane, BorderLayout.CENTER);
        // Panel to show available TacGia
        JPanel panelTacGia = new JPanel();
        panelTacGia.setBorder(BorderFactory.createTitledBorder("Chọn Tác Giả"));
        panelTacGia.setLayout(new BorderLayout());

        listModelTacGia = new DefaultListModel<>();
        listTacGia = new JList<>(listModelTacGia);
        listTacGia.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scrollPaneTacGia = new JScrollPane(listTacGia);
        panelTacGia.add(scrollPaneTacGia, BorderLayout.CENTER);
        // Panel to show selected TacGia
        JPanel panelSelectedTacGia = new JPanel();
        panelSelectedTacGia.setBorder(BorderFactory.createTitledBorder("Tác Giả Được Chọn"));
        panelSelectedTacGia.setLayout(new BorderLayout());

        listModelSelectedTacGia = new DefaultListModel<>();
        listSelectedTacGia = new JList<>(listModelSelectedTacGia);
        JScrollPane scrollPaneSelectedTacGia = new JScrollPane(listSelectedTacGia);
        panelSelectedTacGia.add(scrollPaneSelectedTacGia, BorderLayout.CENTER);
        // Buttons to add and remove selected TacGia
        JPanel panelButtons = new JPanel();
        JButton btnAddTacGia = new JButton("Thêm Tác Giả");
        JButton btnRemoveTacGia = new JButton("Xóa Tác Giả");
        panelButtons.add(btnAddTacGia);
        panelButtons.add(btnRemoveTacGia);

        // Add action listeners for buttons
        btnAddTacGia.addActionListener(e -> addSelectedTacGia());
        btnRemoveTacGia.addActionListener(e -> removeSelectedTacGia());

        JPanel panelTacGiaContainer = new JPanel(new BorderLayout());
        panelTacGiaContainer.add(panelTacGia, BorderLayout.NORTH);
        panelTacGiaContainer.add(panelSelectedTacGia, BorderLayout.CENTER);
        panelTacGiaContainer.add(panelButtons, BorderLayout.SOUTH);

        centerPanel.add(panelTacGiaContainer, BorderLayout.EAST);
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
        tableDauSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displaySelectedRow();
            }
        });

        contentPane.add(footerPanel, BorderLayout.SOUTH);

        // Populate the table with data
        populateDauSachTable();
        populateComboBoxes();
        populateTacGiaList();
    }

// Method to display selected row's data in text fields
private void displaySelectedRow() {
    int selectedRow = tableDauSach.getSelectedRow();
    if (selectedRow != -1) {
        txtMaSach.setText(tableModel.getValueAt(selectedRow, 0).toString());
        txtTuaSach.setText(tableModel.getValueAt(selectedRow, 1).toString());
        txtTomTat.setText(tableModel.getValueAt(selectedRow, 2).toString());
        txtSL.setText(tableModel.getValueAt(selectedRow, 3).toString());
        comboBoxNgonNgu.setSelectedIndex((int) tableModel.getValueAt(selectedRow, 4) - 1);
        comboBoxViTri.setSelectedIndex((int) tableModel.getValueAt(selectedRow, 5) - 1);

        // Clear the existing selected authors list
        listModelSelectedTacGia.clear();

        // Get the list of authors for the selected book and display them
        int maSach = Integer.parseInt(tableModel.getValueAt(selectedRow, 0).toString());
        List<TacGiaModel> tacGiaList = dauSachController.getTacGiaByDauSachId(maSach);
        for (TacGiaModel tg : tacGiaList) {
            listModelSelectedTacGia.addElement(tg.getTenTG());
        }
    }
}

// Method to clear text fields
private void clearTextFields() {
    txtMaSach.setText("");
    txtTuaSach.setText("");
    txtTomTat.setText("");
    txtSL.setText("");
    comboBoxNgonNgu.setSelectedIndex(0);
    comboBoxViTri.setSelectedIndex(0);
    listModelSelectedTacGia.clear();
}
// Method to add selected authors to the list
private void addSelectedTacGia() {
    List<String> selectedTacGia = listTacGia.getSelectedValuesList();
    for (String tacGia : selectedTacGia) {
        if (!listModelSelectedTacGia.contains(tacGia)) {
            listModelSelectedTacGia.addElement(tacGia);
        }
    }
}

// Method to remove selected authors from the list
private void removeSelectedTacGia() {
    List<String> selectedTacGia = listSelectedTacGia.getSelectedValuesList();
    for (String tacGia : selectedTacGia) {
        listModelSelectedTacGia.removeElement(tacGia);
    }
}

// Method to get selected author IDs
private List<Integer> getSelectedTacGiaIds() {
    List<Integer> tacGiaIds = new ArrayList<>();
    for (int i = 0; i < listModelSelectedTacGia.size(); i++) {
        String tacGiaInfo = listModelSelectedTacGia.get(i);
        int maTG = Integer.parseInt(tacGiaInfo.split(" - ")[0]);
        tacGiaIds.add(maTG);
    }
    return tacGiaIds;
}
// Main method to run the application

// Populate JTable with data from the database
private void populateDauSachTable() {
    dauSachController.populateDauSachTable(tableDauSach);
}

// Populate combo boxes with data from the database
private void populateComboBoxes() {
    ngonNguController.populateNgonNguComboBox(comboBoxNgonNgu);
    viTriSachController.populateViTriComboBox(comboBoxViTri);
}

// Populate authors list with data from the database
private void populateTacGiaList() {
    tacGiaController.populateTacGiaList(listModelTacGia);
}
// Method to add a row
private void addRow() {
    // Get data from input fields
    String tuaSach = txtTuaSach.getText().trim();
    String tomTat = txtTomTat.getText().trim();
    String slStr = txtSL.getText().trim();
    int maNN = comboBoxNgonNgu.getSelectedIndex() + 1; // Get selected language ID
    int maVT = comboBoxViTri.getSelectedIndex() + 1; // Get selected location ID

    // Validate input data
    if (tuaSach.isEmpty() || tomTat.isEmpty() || slStr.isEmpty() || maNN == 0 || maVT == 0) {
        JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin sách.");
        return;
    }

    int sl;
    try {
        sl = Integer.parseInt(slStr);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Số lượng phải là số.");
        return;
    }

    // Add book to the database
    boolean isAdded = dauSachController.addDauSach(tuaSach, tomTat, sl, maNN, maVT, getSelectedTacGiaIds());
    if (isAdded) {
        JOptionPane.showMessageDialog(this, "Thêm sách thành công.");
        populateDauSachTable();
        clearTextFields();
    } else {
        JOptionPane.showMessageDialog(this, "Có lỗi trong quá trình thêm sách.");
    }
}

// Method to edit a selected row
private void editRow() {
    int selectedRow = tableDauSach.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa.");
        return;
    }

    String maSachStr = tableModel.getValueAt(selectedRow, 0).toString();
    int maSach = Integer.parseInt(maSachStr);
    String tuaSach = txtTuaSach.getText().trim();
    String tomTat = txtTomTat.getText().trim();
    String slStr = txtSL.getText().trim();
    int maNN = comboBoxNgonNgu.getSelectedIndex() + 1;
    int maVT = comboBoxViTri.getSelectedIndex() + 1;

    if (tuaSach.isEmpty() || tomTat.isEmpty() || slStr.isEmpty() || maNN == 0 || maVT == 0) {
        JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin sách.");
        return;
    }

    int sl;
    try {
        sl = Integer.parseInt(slStr);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Số lượng phải là số.");
        return;
    }

    // Update book in the database
    boolean isUpdated = dauSachController.updateDauSach(maSach, tuaSach, tomTat, sl, maNN, maVT, getSelectedTacGiaIds());
    if (isUpdated) {
        JOptionPane.showMessageDialog(this, "Sửa sách thành công.");
        populateDauSachTable();
        clearTextFields();
    } else {
        JOptionPane.showMessageDialog(this, "Có lỗi trong quá trình sửa sách.");
    }
}

// Method to delete a selected row
private void deleteRow() {
    int selectedRow = tableDauSach.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xóa.");
        return;
    }

    String maSachStr = tableModel.getValueAt(selectedRow, 0).toString();
    int maSach = Integer.parseInt(maSachStr);

    boolean isDeleted = dauSachController.deleteDauSach(maSach);
    if (isDeleted) {
        JOptionPane.showMessageDialog(this, "Xóa sách thành công.");
        populateDauSachTable();
        clearTextFields();
    } else {
        JOptionPane.showMessageDialog(this, "Có lỗi trong quá trình xóa sách.");
    }
}

// Method to save data (if needed, this is just a placeholder)
private void saveData() {
    JOptionPane.showMessageDialog(this, "Lưu dữ liệu thành công.");
}


    
    
}
