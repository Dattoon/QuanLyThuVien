package bookstore.share;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuBarAdmin extends JMenuBar {

    public MenuBarAdmin() {
        // Home menu
        JMenu homeMenu = new JMenu("Trang Chủ");

        // Add menu items to "Trang Chủ"
        JMenuItem borrowReturnItem = new JMenuItem("Mượn trả sách");
        homeMenu.add(borrowReturnItem);

        JMenuItem reportItem = new JMenuItem("Báo cáo");
        homeMenu.add(reportItem);

        this.add(homeMenu);

        // Statistics menu (Quản lý)
        JMenu statsMenu = new JMenu("Quản lý");

        // "Quản lý sách" menu with sub-items
        JMenu manageBooksMenu = new JMenu("Quản lý sách");
        JMenuItem manageBooksItem1 = new JMenuItem("Đầu sách");
        manageBooksMenu.add(manageBooksItem1);
        JMenuItem manageBooksItem2 = new JMenuItem("Ngôn ngữ");
        manageBooksMenu.add(manageBooksItem2);
        JMenuItem manageBooksItem3 = new JMenuItem("Tác giả");
        manageBooksMenu.add(manageBooksItem3);
        statsMenu.add(manageBooksMenu);

        // "Quản lý độc giả" item
        JMenuItem manageReadersItem = new JMenuItem("Quản lý độc giả");
        statsMenu.add(manageReadersItem);

        this.add(statsMenu);

        // Notifications menu (Thông Báo)
        JMenu notificationsMenu = new JMenu("Thông Báo");

        // Add menu items to "Thông Báo"
        JMenuItem overdueBooksItem = new JMenuItem("Sách quá hạn");
        notificationsMenu.add(overdueBooksItem);

        JMenuItem cardRenewalItem = new JMenuItem("Yêu cầu gia hạn thẻ");
        notificationsMenu.add(cardRenewalItem);

        JMenuItem libraryEventsItem = new JMenuItem("Sự kiện thư viện");
        notificationsMenu.add(libraryEventsItem);

        this.add(notificationsMenu);

        // Help menu
        JMenu helpMenu = new JMenu("Trợ Giúp");

        // Add menu items to "Trợ Giúp"
        JMenuItem aboutItem = new JMenuItem("Giới Thiệu");
        helpMenu.add(aboutItem);

        JMenuItem userGuideItem = new JMenuItem("Hướng Dẫn Sử Dụng");
        helpMenu.add(userGuideItem);

        this.add(helpMenu);
    }
}
