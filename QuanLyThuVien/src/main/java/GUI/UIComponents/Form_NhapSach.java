
package GUI.UIComponents;

import BUS.ChiTietPhieuNhap_BUS;
import BUS.NhaCungCap_BUS;
import BUS.NhanVien_BUS;
import BUS.PhieuNhap_BUS;
import BUS.Sach_BUS;
import DTO.ChiTietPhieuNhap;
import DTO.NhaCungCap;
import DTO.PhieuNhap;
import GUI.UIComponents.DATE.DateChooser;
import java.awt.Color;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.CardLayout;
import java.time.LocalDate;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import raven.toast.Notifications;


public class Form_NhapSach extends javax.swing.JPanel {
    
    CardLayout card;
    private PhieuNhap_BUS phieuNhap_BUS;
    private NhaCungCap_BUS nhaCungCap_BUS;
    private NhanVien_BUS nhanVien_BUS;
    private Sach_BUS sach_BUS;
    private ChiTietPhieuNhap_BUS chiTietPhieuNhap_BUS;
    
    private static PhieuNhap phieunhap;
    private static ChiTietPhieuNhap ctpn;
    private static NhaCungCap nhacungcap;
    
    private int RowSelected = -1;
    
    public Form_NhapSach() {
        
        
        initComponents();
        
        nhanVien_BUS = new NhanVien_BUS();
        sach_BUS = new Sach_BUS();
        chiTietPhieuNhap_BUS = new ChiTietPhieuNhap_BUS();
        phieuNhap_BUS = new PhieuNhap_BUS();
        nhaCungCap_BUS = new NhaCungCap_BUS();
        
        card = (CardLayout) this.getLayout();
        card.show(Form_NhapSach.this,"main");
        
        phieuNhap_BUS.RenderPhieuNhap(table_PhieuNhap);
        table_PhieuNhap.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        chiTietPhieuNhap_BUS.RenderCTPN(table_ChiTiet);
        table_ChiTiet.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        nhaCungCap_BUS.RenderNCC(table_NCC);
        table_NCC.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        
        initEvent();
    }
    
    private void initEvent(){
        table_PhieuNhap.addMouseListener(new java.awt.event.MouseAdapter() { // row is clicked
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    if (SwingUtilities.isLeftMouseButton(evt)) {
                        
                        RowSelected = table_PhieuNhap.getSelectedRow();
                        phieunhap = phieuNhap_BUS.SelectedPhieuNhap(Integer.parseInt(table_PhieuNhap.getModel().
                                getValueAt(RowSelected, 0).toString()));
                        
                        mancc_txt.setText(Integer.toString(phieunhap.getMaNCC()));
                        tenncc_txt.setText(nhaCungCap_BUS.getTenNCC(phieunhap.getMaNCC()));
                        
                        manv_txt.setText(Integer.toString(phieunhap.getMaNV()));
                        tennv_txt.setText(nhanVien_BUS.getTenNV(phieunhap.getMaNV()));
                        
                        maphieunhap_txt.setText(Integer.toString(phieunhap.getMaPhieuNhap()));
                        maphieunhap_txt.setEnabled(false);
                        ngaynhap_txt.setText(phieuNhap_BUS.FormatDate(phieunhap.getNgayNhap()));
                         
                    }
                    
                }

            });
         
        table_ChiTiet.addMouseListener(new java.awt.event.MouseAdapter() { // row is clicked
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    if (SwingUtilities.isLeftMouseButton(evt)) {
                        
                        RowSelected = table_ChiTiet.getSelectedRow();
                        ctpn = chiTietPhieuNhap_BUS.SelectedCTPN(Integer.parseInt(table_ChiTiet.getModel().
                                getValueAt(RowSelected, 0).toString()));

                        maCTPN_txt.setText(Integer.toString(ctpn.getMaCTPN()));
                        maCTPN_txt.setEnabled(false);
                        
                        maphieunhap_CT_txt.setText(Integer.toString(ctpn.getMaPhieuNhap()));
                        masach_txt.setText(Integer.toString(ctpn.getMaSach()));
                        tensach_txt.setText(sach_BUS.getTenSach(ctpn.getMaSach()));
                        tensach_txt.setEnabled(false);
                        
                        gia_txt.setText(Integer.toString(ctpn.getGia()));
                        soluong_txt.setText(Integer.toString(ctpn.getSoLuong()));
                         
                    }
                    
                }

            });
         
        table_NCC.addMouseListener(new java.awt.event.MouseAdapter() { // row is clicked
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    if (SwingUtilities.isLeftMouseButton(evt)) {
                        
                        RowSelected = table_NCC.getSelectedRow();
                        nhacungcap = nhaCungCap_BUS.SelectedNCC(Integer.parseInt(table_NCC.getModel().
                                getValueAt(RowSelected, 0).toString()));
                        mancc_NCC_txt.setText(Integer.toString(nhacungcap.getMaNCC()));
                        tennc_NCC_txt.setText(nhacungcap.getTenNCC());
                        mancc_NCC_txt.setEnabled(false);
                         
                    }
                    
                }

            });
         
    }

    public void setToDefault(){
        RowSelected = -1;
        
        //clear select table
        table_PhieuNhap.clearSelection();
        table_NCC.clearSelection();
        table_ChiTiet.clearSelection();
        
        //PN
        mancc_txt.setText("");
        tenncc_txt.setText("");
        manv_txt.setText("");
        tennv_txt.setText("");
        maphieunhap_txt.setText("");
        ngaynhap_txt.setText("");
        maphieunhap_txt.setEnabled(true);
        
        //CTPN
        maCTPN_txt.setText("");
        masach_txt.setText("");
        gia_txt.setText("");
        soluong_txt.setText("");
        maphieunhap_CT_txt.setText("");
        tensach_txt.setText("");
        maCTPN_txt.setEnabled(true);
        
        //NCC
        mancc_NCC_txt.setText("");
        tennc_NCC_txt.setText("");
        mancc_NCC_txt.setEnabled(true);
        
        ctpn = null;
        phieunhap = null;
        nhacungcap = null;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main = new javax.swing.JPanel();
        panelBorder1 = new GUI.UIComponents.Panel.PanelBorder();
        tenncc_txt = new GUI.UIComponents.TextField();
        manv_txt = new GUI.UIComponents.TextField();
        ngaynhap_txt = new GUI.UIComponents.TextField();
        maphieunhap_txt = new GUI.UIComponents.TextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        delete_btn_PN = new GUI.UIComponents.Button();
        add_btn_PN = new GUI.UIComponents.Button();
        save_btn_PN = new GUI.UIComponents.Button();
        chooseDate = new GUI.UIComponents.Button();
        export_PN = new GUI.UIComponents.Button();
        chitiet_btn = new GUI.UIComponents.Button();
        nhacungcap_btn = new GUI.UIComponents.Button();
        mancc_txt = new GUI.UIComponents.TextField();
        tennv_txt = new GUI.UIComponents.TextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_PhieuNhap = new GUI.UIComponents.Table.Table();
        chitiet = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_ChiTiet = new GUI.UIComponents.Table.Table();
        panelBorder2 = new GUI.UIComponents.Panel.PanelBorder();
        back = new GUI.UIComponents.Button();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        maphieunhap_CT_txt = new GUI.UIComponents.TextField();
        gia_txt = new GUI.UIComponents.TextField();
        soluong_txt = new GUI.UIComponents.TextField();
        tensach_txt = new GUI.UIComponents.TextField();
        maCTPN_txt = new GUI.UIComponents.TextField();
        save_btn_CT = new GUI.UIComponents.Button();
        add_btn_CT = new GUI.UIComponents.Button();
        delete_btn_CT = new GUI.UIComponents.Button();
        export_CT = new GUI.UIComponents.Button();
        masach_txt = new GUI.UIComponents.TextField();
        ncc = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_NCC = new GUI.UIComponents.Table.Table();
        panelBorder4 = new GUI.UIComponents.Panel.PanelBorder();
        back1 = new GUI.UIComponents.Button();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        tennc_NCC_txt = new GUI.UIComponents.TextField();
        mancc_NCC_txt = new GUI.UIComponents.TextField();
        save_btn2 = new GUI.UIComponents.Button();
        add_btn2 = new GUI.UIComponents.Button();
        delete_btn2 = new GUI.UIComponents.Button();

        setLayout(new java.awt.CardLayout());

        main.setBackground(new Color(0,0,0,0));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tenncc_txt.setEditable(false);
        tenncc_txt.setEnabled(false);
        tenncc_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        tenncc_txt.setHint("Tên nhà cung cấp");
        panelBorder1.add(tenncc_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 160, 353, 50));

        manv_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder1.add(manv_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 240, 50));

        ngaynhap_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder1.add(ngaynhap_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, 210, 50));

        maphieunhap_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder1.add(maphieunhap_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 240, 50));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(150, 150, 150));
        jLabel5.setText("Mã nhà cung cấp");
        panelBorder1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 123, 100, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(150, 150, 150));
        jLabel6.setText("Ngày nhập");
        panelBorder1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 74, 70, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(150, 150, 150));
        jLabel7.setText("Mã phiếu nhập");
        panelBorder1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 74, 90, -1));

        delete_btn_PN.setIcon(new FlatSVGIcon("IMG/icon/delete.svg",30,30));
        delete_btn_PN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btn_PNActionPerformed(evt);
            }
        });
        panelBorder1.add(delete_btn_PN, new org.netbeans.lib.awtextra.AbsoluteConstraints(458, 6, 41, 42));

        add_btn_PN.setIcon(new FlatSVGIcon("IMG/icon/add.svg",30,30));
        add_btn_PN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btn_PNActionPerformed(evt);
            }
        });
        panelBorder1.add(add_btn_PN, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 6, 41, 42));

        save_btn_PN.setIcon(new FlatSVGIcon("IMG/icon/save.svg",30,30));
        save_btn_PN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_btn_PNActionPerformed(evt);
            }
        });
        panelBorder1.add(save_btn_PN, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 6, 41, 42));

        chooseDate.setBackground(new Color(0,0,0,0));
        chooseDate.setIcon(new FlatSVGIcon("IMG/icon/calendar.svg",30,30));
        chooseDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseDateActionPerformed(evt);
            }
        });
        panelBorder1.add(chooseDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 70, 30, 30));

        export_PN.setBackground(new Color(0,0,0,0)
        );
        export_PN.setIcon(new FlatSVGIcon("IMG/icon/excel.svg",40,40)
        );
        panelBorder1.add(export_PN, new org.netbeans.lib.awtextra.AbsoluteConstraints(754, 10, 40, 40));

        chitiet_btn.setBackground(Color.decode("#00abfd"));
        chitiet_btn.setForeground(new java.awt.Color(255, 255, 255));
        chitiet_btn.setText("Chi Tiết ");
        chitiet_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chitiet_btnActionPerformed(evt);
            }
        });
        panelBorder1.add(chitiet_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        nhacungcap_btn.setBackground(Color.decode("#00abfd"));
        nhacungcap_btn.setForeground(new java.awt.Color(255, 255, 255));
        nhacungcap_btn.setText("Nhà Cung Cấp");
        nhacungcap_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhacungcap_btnActionPerformed(evt);
            }
        });
        panelBorder1.add(nhacungcap_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        mancc_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder1.add(mancc_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 250, 50));

        tennv_txt.setEditable(false);
        tennv_txt.setEnabled(false);
        tennv_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder1.add(tennv_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 240, 50));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(150, 150, 150));
        jLabel13.setText("Mã nhân viên");
        panelBorder1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 123, 80, 20));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(150, 150, 150));
        jLabel16.setText("Tên nhân viên");
        panelBorder1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 172, 80, 20));

        table_PhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Phiếu Nhập", "Mã Nhà Cung Cấp", "Mã Nhân Viên", "Ngày Nhập"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_PhieuNhap.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(table_PhieuNhap);

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(main, "card2");

        chitiet.setBackground(new Color(0,0,0,0));

        table_ChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Chi Tiết Phiếu", "Mã Phiếu Nhập", "Mã Sách", "Giá", "Số Lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_ChiTiet.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jScrollPane2.setViewportView(table_ChiTiet);

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back.setBackground(Color.decode("#00abfd"));
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setIcon(new FlatSVGIcon("IMG/icon/back.svg",15,15)
        );
        back.setText("Trở Lại");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        panelBorder2.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(150, 150, 150));
        jLabel8.setText("Mã sách");
        panelBorder2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 174, 90, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(150, 150, 150));
        jLabel9.setText("Giá");
        panelBorder2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 74, 60, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(150, 150, 150));
        jLabel10.setText("Mã chi tiết phiếu ");
        panelBorder2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 72, 100, 20));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(150, 150, 150));
        jLabel11.setText("Số lượng");
        panelBorder2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 123, 60, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(150, 150, 150));
        jLabel12.setText("Mã phiếu nhập");
        panelBorder2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 123, 90, -1));

        maphieunhap_CT_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder2.add(maphieunhap_CT_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 260, 50));

        gia_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder2.add(gia_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 265, 50));

        soluong_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder2.add(soluong_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 265, 50));

        tensach_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        tensach_txt.setHint("Tên sách");
        panelBorder2.add(tensach_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 160, 330, 50));

        maCTPN_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder2.add(maCTPN_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 260, 50));

        save_btn_CT.setIcon(new FlatSVGIcon("IMG/icon/save.svg",30,30));
        save_btn_CT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_btn_CTActionPerformed(evt);
            }
        });
        panelBorder2.add(save_btn_CT, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 6, 41, 42));

        add_btn_CT.setIcon(new FlatSVGIcon("IMG/icon/add.svg",30,30));
        add_btn_CT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btn_CTActionPerformed(evt);
            }
        });
        panelBorder2.add(add_btn_CT, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 6, 41, 42));

        delete_btn_CT.setIcon(new FlatSVGIcon("IMG/icon/delete.svg",30,30));
        delete_btn_CT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btn_CTActionPerformed(evt);
            }
        });
        panelBorder2.add(delete_btn_CT, new org.netbeans.lib.awtextra.AbsoluteConstraints(458, 6, 41, 42));

        export_CT.setBackground(new Color(0,0,0,0)
        );
        export_CT.setIcon(new FlatSVGIcon("IMG/icon/excel.svg",40,40)
        );
        panelBorder2.add(export_CT, new org.netbeans.lib.awtextra.AbsoluteConstraints(754, 10, 40, 40));

        masach_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder2.add(masach_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 260, 50));

        javax.swing.GroupLayout chitietLayout = new javax.swing.GroupLayout(chitiet);
        chitiet.setLayout(chitietLayout);
        chitietLayout.setHorizontalGroup(
            chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
        );
        chitietLayout.setVerticalGroup(
            chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chitietLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(chitiet, "card3");

        ncc.setBackground(new Color(0,0,0,0));

        table_NCC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhà Cung Cấp", "Tên Nhà Cung Cấp"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_NCC.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jScrollPane3.setViewportView(table_NCC);

        panelBorder4.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back1.setBackground(Color.decode("#00abfd"));
        back1.setForeground(new java.awt.Color(255, 255, 255));
        back1.setIcon(new FlatSVGIcon("IMG/icon/back.svg",15,15)
        );
        back1.setText("Trở Lại");
        back1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back1ActionPerformed(evt);
            }
        });
        panelBorder4.add(back1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(150, 150, 150));
        jLabel14.setText("Tên nhà cung cấp");
        panelBorder4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 154, 110, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(150, 150, 150));
        jLabel15.setText("Mã Nhà Cung  Cấp");
        panelBorder4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 72, 110, 20));

        tennc_NCC_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder4.add(tennc_NCC_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 360, 50));

        mancc_NCC_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder4.add(mancc_NCC_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 360, 50));

        save_btn2.setIcon(new FlatSVGIcon("IMG/icon/save.svg",30,30));
        save_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_btn2ActionPerformed(evt);
            }
        });
        panelBorder4.add(save_btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 6, 41, 42));

        add_btn2.setIcon(new FlatSVGIcon("IMG/icon/add.svg",30,30));
        add_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btn2ActionPerformed(evt);
            }
        });
        panelBorder4.add(add_btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 6, 41, 42));

        delete_btn2.setIcon(new FlatSVGIcon("IMG/icon/delete.svg",30,30));
        delete_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btn2ActionPerformed(evt);
            }
        });
        panelBorder4.add(delete_btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(458, 6, 41, 42));

        javax.swing.GroupLayout nccLayout = new javax.swing.GroupLayout(ncc);
        ncc.setLayout(nccLayout);
        nccLayout.setHorizontalGroup(
            nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addComponent(panelBorder4, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
        );
        nccLayout.setVerticalGroup(
            nccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nccLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(ncc, "card4");
    }// </editor-fold>//GEN-END:initComponents

    private void delete_btn_PNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btn_PNActionPerformed
        if (RowSelected != -1) {
            ImageIcon icon = new FlatSVGIcon("IMG/icon/warning.svg",30,30);
            String[] cf = {"Đồng ý", "Hủy"};
            int choice = JOptionPane.showOptionDialog(null,"Xóa phiếu nhập \"" + phieunhap.getMaPhieuNhap() + 
                    "\" ? \n Chi tiết phiếu nhập cũng sẽ bị xóa.","Xác Nhận",
                     JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, cf ,null);
            if (choice == 0) {
                
                if (phieuNhap_BUS.XoaPhieuNhap(phieunhap)) {
                    table_PhieuNhap.deleteRow(RowSelected);
                    Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 
                    "Xóa phiếu nhập thành công.");
                    setToDefault();
                    
                }
            }
        }else{
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Vui lòng chọn phiếu nhập.");
        }
    }//GEN-LAST:event_delete_btn_PNActionPerformed

    private void add_btn_PNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btn_PNActionPerformed
        setToDefault();
    }//GEN-LAST:event_add_btn_PNActionPerformed

    private void save_btn_PNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btn_PNActionPerformed
        
        boolean checked = false;
        int mapn = -1;
        int mancc = -1;
        int manv = -1;
        LocalDate date = LocalDate.now();
        try {
            checked = true;
            mapn = Integer.parseInt(maphieunhap_txt.getText());
            mancc = Integer.parseInt(mancc_txt.getText());
            manv = Integer.parseInt(manv_txt.getText());
            date = phieuNhap_BUS.FormatDateSQL(ngaynhap_txt.getText());
            
        } catch (Exception e) {
            checked = false;
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
            "Dữ liệu không đúng định dạng.");
        }
        
        if (checked){  
            if (RowSelected == -1 && phieunhap == null) {
                
                phieunhap = new PhieuNhap(mapn, mancc, manv, date);

                if (phieuNhap_BUS.ThemPhieuNhap(phieunhap)) {
                    table_PhieuNhap.addRow(new Object[] {mapn, mancc, manv,phieuNhap_BUS.FormatDate(date)});
                }

            phieunhap = null;

            }else { 
                PhieuNhap pnUpdate =  new PhieuNhap(mapn, mancc, manv, date);
                if (phieuNhap_BUS.SuaPhieuNhap(pnUpdate, phieunhap)) {

                    table_PhieuNhap.updateRow(RowSelected, new Object[] {mapn, mancc, manv, phieuNhap_BUS.FormatDate(date)});                   
                    phieunhap = pnUpdate;
                    pnUpdate = null;
                    
                }
            }
        }
    }//GEN-LAST:event_save_btn_PNActionPerformed

    private void chooseDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseDateActionPerformed
        DateChooser date = new DateChooser();
        date.setTextRefernce(ngaynhap_txt);
        date.showPopup(chooseDate, - 186, -50);
    }//GEN-LAST:event_chooseDateActionPerformed

    private void chitiet_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chitiet_btnActionPerformed
        
        if (RowSelected != -1 && phieunhap != null) {      
            try {

                int mapn = phieunhap.getMaPhieuNhap();
                RowSelected = table_ChiTiet.find(mapn);
                
                if (RowSelected != -1) {
                    table_ChiTiet.setRowSelectionInterval(RowSelected, RowSelected);
                    
                    ctpn = chiTietPhieuNhap_BUS.SelectedCTPN(Integer.parseInt(table_ChiTiet.getModel().
                    getValueAt(RowSelected, 0).toString()));

                    maCTPN_txt.setText(Integer.toString(ctpn.getMaCTPN()));

                    maphieunhap_CT_txt.setText(Integer.toString(ctpn.getMaPhieuNhap()));
                    masach_txt.setText(Integer.toString(ctpn.getMaSach()));
                    tensach_txt.setText(sach_BUS.getTenSach(ctpn.getMaSach()));
                    tensach_txt.setEnabled(false);

                    gia_txt.setText(Integer.toString(ctpn.getGia()));
                    soluong_txt.setText(Integer.toString(ctpn.getSoLuong()));

                    card.next(this);
                }

            } catch (NullPointerException e) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                        "Chi tiết phiếu nhập không tồn tại.");
                
            } catch (IllegalArgumentException e){
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                        "Chi tiết phiếu nhập không tồn tại.");
            }
            
        }else { 
             card.next(this);
        }
        
    }//GEN-LAST:event_chitiet_btnActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        card.first(this);
    }//GEN-LAST:event_backActionPerformed

    private void save_btn_CTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btn_CTActionPerformed
           
        boolean checked = false;
        int mapn = -1;
        int mactpn = -1;
        int masach = -1;
        int gia = -1;
        int sl = -1;
        
        try {
            checked = true;
            mapn = Integer.parseInt(maphieunhap_CT_txt.getText());
            mactpn = Integer.parseInt(maCTPN_txt.getText());
            masach = Integer.parseInt(masach_txt.getText());
            gia = Integer.parseInt(gia_txt.getText());
            sl = Integer.parseInt(soluong_txt.getText());
            
        } catch (Exception e) {
            checked = false;
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
            "Dữ liệu không đúng định dạng.");
        }
        
        if (checked){  
            if (RowSelected == -1 && ctpn == null) {
                
                ctpn = new ChiTietPhieuNhap(mactpn, mapn, masach, gia ,sl);

                if (chiTietPhieuNhap_BUS.ThemCTPN(ctpn)) {
                    
                    table_ChiTiet.addRow(new Object[] {mactpn, mapn, masach, gia ,sl}); 
                }

                ctpn = null;

            }else { 
                
                ChiTietPhieuNhap ctpnUpdate = new ChiTietPhieuNhap(mactpn, mapn, masach, gia ,sl);
                if (chiTietPhieuNhap_BUS.SuaCTPN(ctpnUpdate, ctpn)) {

                    table_ChiTiet.updateRow(RowSelected, new Object[] {mactpn, mapn, masach, gia ,sl}); 
                    tensach_txt.setText(sach_BUS.getTenSach(masach));                
                    ctpn = ctpnUpdate;
                    ctpnUpdate = null;
                    
                }
            }
        }
    }//GEN-LAST:event_save_btn_CTActionPerformed

    private void add_btn_CTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btn_CTActionPerformed
        setToDefault();
    }//GEN-LAST:event_add_btn_CTActionPerformed

    private void delete_btn_CTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btn_CTActionPerformed
         if (RowSelected != -1) {
            ImageIcon icon = new FlatSVGIcon("IMG/icon/warning.svg",30,30);
            String[] cf = {"Đồng ý", "Hủy"};
            int choice = JOptionPane.showOptionDialog(null,"Xóa chi tiết phiếu nhập \"" + ctpn.getMaCTPN() + 
                    "\" ?","Xác Nhận",
                     JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, cf ,null);
            if (choice == 0) {
                
                if (chiTietPhieuNhap_BUS.XoaCTPN(ctpn)) {
                    table_ChiTiet.deleteRow(RowSelected);
                    Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 
                    "Xóa chi tiết phiếu nhập thành công.");
                    setToDefault();
                    
                }
            }
        }else{
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Vui lòng chọn chi tiết phiếu nhập.");
        }
    }//GEN-LAST:event_delete_btn_CTActionPerformed

    private void back1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back1ActionPerformed
        card.first(this);
    }//GEN-LAST:event_back1ActionPerformed

    private void save_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btn2ActionPerformed
        boolean checked = false;
        int mancc = -1;
        String tenncc = "";
        
        try {
            checked = true;
            mancc = Integer.parseInt(mancc_NCC_txt.getText());
            tenncc = tennc_NCC_txt.getText();
            
        } catch (Exception e) {
            checked = false;
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
            "Dữ liệu không đúng định dạng.");
        }
        
        if (checked){  
            if (RowSelected == -1 && nhacungcap == null) {
                
                nhacungcap = new NhaCungCap(mancc, tenncc);

                if (nhaCungCap_BUS.ThemNCC(nhacungcap)) {
                    
                    table_NCC.addRow(new Object[] {mancc, tenncc}); 
                }

                nhacungcap = null;

            }else { 
                
                NhaCungCap nccUpdate = new NhaCungCap(mancc, tenncc);
                if (nhaCungCap_BUS.SuaNCC(nccUpdate, nhacungcap)) {

                    table_NCC.updateRow(RowSelected, new Object[] {mancc, tenncc});                
                    nhacungcap = nccUpdate;
                    nccUpdate = null;
                    
                }
            }
        }
    }//GEN-LAST:event_save_btn2ActionPerformed

    private void add_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btn2ActionPerformed
        setToDefault();
    }//GEN-LAST:event_add_btn2ActionPerformed

    private void delete_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btn2ActionPerformed
        if (RowSelected != -1) {
            ImageIcon icon = new FlatSVGIcon("IMG/icon/warning.svg",30,30);
            String[] cf = {"Đồng ý", "Hủy"};
            int choice = JOptionPane.showOptionDialog(null,"Xóa nhà cung cấp \"" + nhacungcap.getMaNCC() + 
                    "\" ? \n Tất cả sách của nhà cung cấp cũng sẽ bị xóa","Xác Nhận",
                     JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, cf ,null);
            if (choice == 0) {
                
                if (nhaCungCap_BUS.XoaNCC(nhacungcap)) {
                    
                    setToDefault();
                    table_NCC.deleteRow(RowSelected);
                    
                }
            }
        }else{
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Vui lòng chọn nhà cung cấp.");
        }
    }//GEN-LAST:event_delete_btn2ActionPerformed

    private void nhacungcap_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhacungcap_btnActionPerformed
        card.last(this);
        
    }//GEN-LAST:event_nhacungcap_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.UIComponents.Button add_btn2;
    private GUI.UIComponents.Button add_btn_CT;
    private GUI.UIComponents.Button add_btn_PN;
    private GUI.UIComponents.Button back;
    private GUI.UIComponents.Button back1;
    private javax.swing.JPanel chitiet;
    private GUI.UIComponents.Button chitiet_btn;
    private GUI.UIComponents.Button chooseDate;
    private GUI.UIComponents.Button delete_btn2;
    private GUI.UIComponents.Button delete_btn_CT;
    private GUI.UIComponents.Button delete_btn_PN;
    private GUI.UIComponents.Button export_CT;
    private GUI.UIComponents.Button export_PN;
    private GUI.UIComponents.TextField gia_txt;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private GUI.UIComponents.TextField maCTPN_txt;
    private javax.swing.JPanel main;
    private GUI.UIComponents.TextField mancc_NCC_txt;
    private GUI.UIComponents.TextField mancc_txt;
    private GUI.UIComponents.TextField manv_txt;
    private GUI.UIComponents.TextField maphieunhap_CT_txt;
    private GUI.UIComponents.TextField maphieunhap_txt;
    private GUI.UIComponents.TextField masach_txt;
    private javax.swing.JPanel ncc;
    private GUI.UIComponents.TextField ngaynhap_txt;
    private GUI.UIComponents.Button nhacungcap_btn;
    private GUI.UIComponents.Panel.PanelBorder panelBorder1;
    private GUI.UIComponents.Panel.PanelBorder panelBorder2;
    private GUI.UIComponents.Panel.PanelBorder panelBorder4;
    private GUI.UIComponents.Button save_btn2;
    private GUI.UIComponents.Button save_btn_CT;
    private GUI.UIComponents.Button save_btn_PN;
    private GUI.UIComponents.TextField soluong_txt;
    private GUI.UIComponents.Table.Table table_ChiTiet;
    private GUI.UIComponents.Table.Table table_NCC;
    private GUI.UIComponents.Table.Table table_PhieuNhap;
    private GUI.UIComponents.TextField tennc_NCC_txt;
    private GUI.UIComponents.TextField tenncc_txt;
    private GUI.UIComponents.TextField tennv_txt;
    private GUI.UIComponents.TextField tensach_txt;
    // End of variables declaration//GEN-END:variables
}
