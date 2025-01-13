package bookstore.view;

import bookstore.controller.DauSachController;
import bookstore.controller.TacGiaController;
import bookstore.model.DauSachModel;
import bookstore.model.TacGiaModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DauSachDialog extends JDialog {

    private JTextField tuaSachField;
    private JTextField tomTatField;
    private JTextField slField;
    private JComboBox<String> ngonNguComboBox;
    private JComboBox<String> viTriComboBox;
    private JList<TacGiaModel> tacGiaList;

    private JButton saveButton;
    private JButton cancelButton;

    private DauSachController dauSachController;
    private TacGiaController tacGiaController;

    private boolean saved;
    private DauSachModel dauSach;

    public DauSachDialog(Frame owner, DauSachModel dauSach) {
        super(owner, true);
        this.dauSach = dauSach;
        dauSachController = new DauSachController();
        tacGiaController = new TacGiaController();

        initComponents();
        setData();
        setTitle(dauSach == null ? "Thêm Đầu Sách" : "Sửa Đầu Sách");
        setSize(500, 400);
        setLocationRelativeTo(owner);
    }

    private void initComponents() {
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));

        formPanel.add(new JLabel("Tựa Sách:"));
        tuaSachField = new JTextField();
        formPanel.add(tuaSachField);

        formPanel.add(new JLabel("Tóm Tắt:"));
        tomTatField = new JTextField();
        formPanel.add(tomTatField);

        formPanel.add(new JLabel("Số Lượng:"));
        slField = new JTextField();
        formPanel.add(slField);

        formPanel.add(new JLabel("Ngôn Ngữ:"));
        ngonNguComboBox = new JComboBox<>(new String[]{"Ngôn Ngữ 1", "Ngôn Ngữ 2"});
        formPanel.add(ngonNguComboBox);

        formPanel.add(new JLabel("Vị Trí:"));
        viTriComboBox = new JComboBox<>(new String[]{"Vị Trí 1", "Vị Trí 2"});
        formPanel.add(viTriComboBox);

        formPanel.add(new JLabel("Tác Giả:"));
        tacGiaList = new JList<>();
        tacGiaList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        loadTacGiaList();
        JScrollPane listScrollPane = new JScrollPane(tacGiaList);
        formPanel.add(listScrollPane);

        add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        saveButton = new JButton("Lưu");
        cancelButton = new JButton("Hủy");
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);

        add(buttonPanel, BorderLayout.SOUTH);

        saveButton.addActionListener(e -> saveData());
        cancelButton.addActionListener(e -> dispose());
    }

    private void loadTacGiaList() {
        List<TacGiaModel> tacGiaListData = tacGiaController.getAllTacGia();
        DefaultListModel<TacGiaModel> listModel = new DefaultListModel<>();
        for (TacGiaModel tacGia : tacGiaListData) {
            listModel.addElement(tacGia);
        }
        tacGiaList.setModel(listModel);
    }

    private void setData() {
        if (dauSach != null) {
            tuaSachField.setText(dauSach.getTuaSach());
            tomTatField.setText(dauSach.getTomTat());
            slField.setText(String.valueOf(dauSach.getSl()));
            ngonNguComboBox.setSelectedItem(dauSach.getMaNN());
            viTriComboBox.setSelectedItem(dauSach.getMaVT());

            // Load danh sách tác giả liên kết với đầu sách
            List<TacGiaModel> linkedTacGia = dauSachController.getTacGiaByDauSachId(dauSach.getMaSach());
            tacGiaList.clearSelection();
            for (int i = 0; i < tacGiaList.getModel().getSize(); i++) {
                TacGiaModel tacGia = tacGiaList.getModel().getElementAt(i);
                if (linkedTacGia.contains(tacGia)) {
                    tacGiaList.addSelectionInterval(i, i);
                }
            }
        }
    }

    private void saveData() {
        String tuaSach = tuaSachField.getText();
        String tomTat = tomTatField.getText();
        int sl;
        try {
            sl = Integer.parseInt(slField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số lượng phải là số nguyên.");
            return;
        }
        int maNN = ngonNguComboBox.getSelectedIndex() + 1;
        int maVT = viTriComboBox.getSelectedIndex() + 1;

        // Lấy danh sách tác giả được chọn
        List<TacGiaModel> selectedTacGia = tacGiaList.getSelectedValuesList();
        List<Integer> maTacGiaList = new ArrayList<>();
        for (TacGiaModel tacGia : selectedTacGia) {
            maTacGiaList.add(tacGia.getMaTG());
        }

        if (dauSach == null) {
            // Thêm mới đầu sách
            int newId = dauSachController.addDauSach(tuaSach, tomTat, sl, maNN, maVT, maTacGiaList);
            if (newId > 0) {
                saved = true;
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm đầu sách thất bại.");
            }
        } else {
            // Cập nhật đầu sách
            boolean success = dauSachController.updateDauSach(dauSach.getMaSach(), tuaSach, tomTat, sl, maNN, maVT, maTacGiaList);
            if (success) {
                saved = true;
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật đầu sách thất bại.");
            }
        }
    }

    public boolean isSaved() {
        return saved;
    }
}
