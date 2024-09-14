
package GUI.UIComponents;

import BUS.CTPNBUS;
import BUS.ChiTietPhieuNhap_BUS;
import BUS.LoaiSach_BUS;
import BUS.NhaCungCap_BUS;
import BUS.NhaXuatBan_BUS;
import BUS.NhanVien_BUS;
import BUS.PhieuNhap_BUS;
import BUS.Sach_BUS;
import BUS.TacGia_BUS;
import DTO.Accounts;
import DTO.CTPNDTO;
import DTO.ChiTietPhieuNhap;
import DTO.NhaCungCap;
import DTO.NhanVien;
import DTO.PhieuNhap;
import DTO.Sach;
import GUI.UIComponents.DATE.DateChooser;
import GUI.UIComponents.FileChooser.JnaFileChooser;
import GUI.UIComponents.Table.Table;
import java.awt.Color;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.StandardCopyOption;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFileChooser;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import raven.toast.Notifications;


public class Form_NhapSach extends javax.swing.JPanel {
    
    CardLayout card;
    private PhieuNhap_BUS phieuNhap_BUS;
    private Sach sach;
    private NhaCungCap_BUS nhaCungCap_BUS;
    private NhanVien_BUS nhanVien_BUS;
    private Sach_BUS sach_BUS;
    private ChiTietPhieuNhap_BUS chiTietPhieuNhap_BUS;
    
    private CTPNBUS ctpnBUS;
    private CTPNDTO ctpnDTO;
    
    private static PhieuNhap phieunhap;
    private static ChiTietPhieuNhap ctpn;
    private static NhaCungCap nhacungcap;
    private static Accounts acc;
    private static NhanVien nv;

    private LoaiSach_BUS loaiSach_BUS;
    private NhaXuatBan_BUS nhaXuatBan_BUS;
    private TacGia_BUS tacGia_BUS;
    
    private DateChooser date = new DateChooser();
    
    
    private int RowSelected = -1;
    private JFileChooser fileChooser;
    private ImageIcon defaultIMG =new FlatSVGIcon("IMG/Sach/default.svg",190,250);
    private int isSelectedIMG;
    ArrayList<Integer> masachList;
    
    private ArrayList<Sach> arrayListSach = null;
    private int id;
   
    
    
    
    
    public Form_NhapSach(Accounts accounts) {
        Form_NhapSach.acc = accounts;
        
        
        initComponents();
        
        
        nhanVien_BUS = new NhanVien_BUS();
        sach_BUS = new Sach_BUS();
        chiTietPhieuNhap_BUS = new ChiTietPhieuNhap_BUS();
        loaiSach_BUS = new LoaiSach_BUS();
        nhaXuatBan_BUS = new NhaXuatBan_BUS();
        tacGia_BUS = new TacGia_BUS();
        phieuNhap_BUS = new PhieuNhap_BUS();
        nhaCungCap_BUS = new NhaCungCap_BUS();
        nv = nhanVien_BUS.SelectedNhanVien(acc.getMaTaiKhoan());
        
        nhaCungCap_BUS.ChonNCC(ChonNCC);
        id = sach_BUS.getNewID();
        
        
        
        ChonNCC.setSelectedIndex(-1);
        
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
                        
                        

                        manv_txt.setText(Integer.toString(phieunhap.getMaNV()));
                        manv_txt.setEnabled(false);
                        maphieunhap_txt.setText(Integer.toString(phieunhap.getMaPhieuNhap()));
                        maphieunhap_txt.setEnabled(false);
                        ngaynhap_txt.setText(phieuNhap_BUS.FormatDate(phieunhap.getNgayNhap()));
                        ngaynhap_txt.setEnabled(false);
                        ChonNCC.setItemCombobox(nhaCungCap_BUS.getTenNCC(phieunhap.getMaNCC()));
                        chooseDate.setEnabled(false);
                        ChonNCC.setEnabled(false);
                         
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

                        tensach_txt.setText(sach_BUS.getTenSach(ctpn.getMaSach()));
                        tensach_txt.setEnabled(false);
                        
                        
                        tentacgia_txt.setText(tacGia_BUS.getTTG(sach_BUS.SelectedSach(ctpn.getMaSach()).getMaTacGia()));
                        tentacgia_txt.setEnabled(false);
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
    
    public Table getTable_PN(){
        return table_PhieuNhap;
    }
    public Table getTable_CTPN(){
        return table_ChiTiet;
    }
    public Table getTable_NCC(){
        return table_NCC;
    }

    public void setToDefault(){
        RowSelected = -1;
        
        //clear select table
        table_PhieuNhap.clearSelection();
        table_NCC.clearSelection();
        table_ChiTiet.clearSelection();
        
        //PN
        maphieunhap_txt.setText("");
        ngaynhap_txt.setText("");
        maphieunhap_txt.setEnabled(true);
        
        //CTPN

        tensach_txt.setText("");
        tentacgia_txt.setText("");
        
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

        ThemSachMoi = new javax.swing.JDialog();
        panelBorder3 = new GUI.UIComponents.Panel.PanelBorder();
        jLabel4 = new javax.swing.JLabel();
        ts_txt = new GUI.UIComponents.TextField();
        ChonTG = new GUI.UIComponents.Combobox();
        ChonNXB = new GUI.UIComponents.Combobox();
        jlabel = new javax.swing.JLabel();
        sl_txt = new GUI.UIComponents.TextField();
        chooseDate1 = new GUI.UIComponents.Button();
        ChonTheLoai = new GUI.UIComponents.Combobox();
        nxb_txt = new GUI.UIComponents.TextField();
        jlabell1 = new javax.swing.JLabel();
        IMG = new javax.swing.JLabel();
        ChooseIMG = new GUI.UIComponents.Button();
        xong_btn = new GUI.UIComponents.Button();
        nhaptiep_btn = new GUI.UIComponents.Button();
        ms_txt = new GUI.UIComponents.TextField();
        jLabel18 = new javax.swing.JLabel();
        ThemSachCu = new javax.swing.JDialog();
        panelBorder5 = new GUI.UIComponents.Panel.PanelBorder();
        screach1 = new GUI.UIComponents.Screach();
        table_Sach = new GUI.UIComponents.Table.Table();
        jScrollPane = new javax.swing.JScrollPane();
        tb_sach = new GUI.UIComponents.Table.Table();
        xong_btn1 = new GUI.UIComponents.Button();
        sl_ctpn_txt = new GUI.UIComponents.TextField();
        jLabel3 = new javax.swing.JLabel();
        luu_btn = new GUI.UIComponents.Button();
        KiemTra = new javax.swing.JDialog();
        main = new javax.swing.JPanel();
        panelBorder1 = new GUI.UIComponents.Panel.PanelBorder();
        manv_txt = new GUI.UIComponents.TextField();
        ngaynhap_txt = new GUI.UIComponents.TextField();
        maphieunhap_txt = new GUI.UIComponents.TextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        delete_btn_PN = new GUI.UIComponents.Button();
        add_btn_PN = new GUI.UIComponents.Button();
        save_btn_PN = new GUI.UIComponents.Button();
        chooseDate = new GUI.UIComponents.Button();
        export_PN = new GUI.UIComponents.Button();
        chitiet_btn = new GUI.UIComponents.Button();
        nhacungcap_btn = new GUI.UIComponents.Button();
        jLabel13 = new javax.swing.JLabel();
        ChonNCC = new GUI.UIComponents.Combobox();
        nhapsachmoi_btn = new GUI.UIComponents.Button();
        kiemtra_btn = new GUI.UIComponents.Button();
        nhapsachcu_btn = new GUI.UIComponents.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_PhieuNhap = new GUI.UIComponents.Table.Table();
        chitiet = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_ChiTiet = new GUI.UIComponents.Table.Table();
        panelBorder2 = new GUI.UIComponents.Panel.PanelBorder();
        back = new GUI.UIComponents.Button();
        tensach_txt = new GUI.UIComponents.TextField();
        tentacgia_txt = new GUI.UIComponents.TextField();
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

        ThemSachMoi.setMinimumSize(new java.awt.Dimension(600, 500));
        ThemSachMoi.setModal(true);
        ThemSachMoi.setPreferredSize(new java.awt.Dimension(600, 500));
        ThemSachMoi.setResizable(false);

        panelBorder3.setBackground(Color.decode("#f2f2f2"));
        panelBorder3.setPreferredSize(new java.awt.Dimension(600, 450));
        panelBorder3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(150, 150, 150));
        jLabel4.setText("Tên sách");
        panelBorder3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 70, -1));

        ts_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder3.add(ts_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 250, 50));

        ChonTG.setLabeText("Tác giả");
        ChonTG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChonTGActionPerformed(evt);
            }
        });
        panelBorder3.add(ChonTG, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 330, 40));

        ChonNXB.setLabeText("Nhà xuất bản");
        panelBorder3.add(ChonNXB, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 330, 40));

        jlabel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jlabel.setForeground(new java.awt.Color(150, 150, 150));
        jlabel.setText("Năm xuất bản");
        panelBorder3.add(jlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        sl_txt.setDisabledTextColor(new java.awt.Color(80, 80, 80));
        sl_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder3.add(sl_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 250, 50));

        chooseDate1.setBackground(new Color(0,0,0,0));
        chooseDate1.setIcon(new FlatSVGIcon("IMG/icon/calendar.svg",30,30));
        chooseDate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseDate1ActionPerformed(evt);
            }
        });
        panelBorder3.add(chooseDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 30, 30));

        ChonTheLoai.setLabeText("Loại sách");
        panelBorder3.add(ChonTheLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 330, 40));

        nxb_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder3.add(nxb_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 220, 50));

        jlabell1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jlabell1.setForeground(new java.awt.Color(150, 150, 150));
        jlabell1.setText("Số lượng");
        panelBorder3.add(jlabell1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        IMG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IMG.setIcon(new FlatSVGIcon("IMG/sach/default.svg",190,250
        ));
        panelBorder3.add(IMG, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 190, 250));

        ChooseIMG.setBackground(Color.decode("#00abfd")
        );
        ChooseIMG.setForeground(new java.awt.Color(255, 255, 255));
        ChooseIMG.setText("Chọn ảnh");
        ChooseIMG.setShadowColor(new java.awt.Color(3, 155, 216));
        ChooseIMG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChooseIMGActionPerformed(evt);
            }
        });
        panelBorder3.add(ChooseIMG, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, 190, 30));

        xong_btn.setBackground(Color.decode("#00abfd"));
        xong_btn.setForeground(new java.awt.Color(255, 255, 255));
        xong_btn.setText("Xong");
        xong_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xong_btnActionPerformed(evt);
            }
        });
        panelBorder3.add(xong_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 400, 110, -1));

        nhaptiep_btn.setBackground(Color.decode("#00abfd"));
        nhaptiep_btn.setForeground(new java.awt.Color(255, 255, 255));
        nhaptiep_btn.setText("Nhập Tiếp");
        nhaptiep_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhaptiep_btnActionPerformed(evt);
            }
        });
        panelBorder3.add(nhaptiep_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 110, -1));

        ms_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        ms_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ms_txtActionPerformed(evt);
            }
        });
        panelBorder3.add(ms_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 250, 50));

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(150, 150, 150));
        jLabel18.setText("Mã sách");
        panelBorder3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 50, -1));

        javax.swing.GroupLayout ThemSachMoiLayout = new javax.swing.GroupLayout(ThemSachMoi.getContentPane());
        ThemSachMoi.getContentPane().setLayout(ThemSachMoiLayout);
        ThemSachMoiLayout.setHorizontalGroup(
            ThemSachMoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ThemSachMoiLayout.setVerticalGroup(
            ThemSachMoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder3, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        ThemSachCu.setMinimumSize(new java.awt.Dimension(600, 500));
        ThemSachCu.setModal(true);
        ThemSachCu.setPreferredSize(new java.awt.Dimension(600, 500));
        ThemSachCu.setResizable(false);

        panelBorder5.setBackground(Color.decode("#f2f2f2"));
        panelBorder5.setPreferredSize(new java.awt.Dimension(600, 500));

        table_Sach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sách", "Tên sách", "Nhà xuất bản", "Năm xuất bản", "Tác giả", "SL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_Sach.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        jScrollPane.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jScrollPaneMouseWheelMoved(evt);
            }
        });

        tb_sach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sách", "Tên sách", "Tác giả", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_sach.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jScrollPane.setViewportView(tb_sach);
        if (tb_sach.getColumnModel().getColumnCount() > 0) {
            tb_sach.getColumnModel().getColumn(0).setResizable(false);
            tb_sach.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        xong_btn1.setBackground(Color.decode("#00abfd"));
        xong_btn1.setForeground(new java.awt.Color(255, 255, 255));
        xong_btn1.setText("Xong");
        xong_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xong_btn1ActionPerformed(evt);
            }
        });

        sl_ctpn_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        sl_ctpn_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sl_ctpn_txtActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(150, 150, 150));
        jLabel3.setText("Số lượng");

        luu_btn.setBackground(Color.decode("#00abfd"));
        luu_btn.setForeground(new java.awt.Color(255, 255, 255));
        luu_btn.setText("Lưu");
        luu_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                luu_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBorder5Layout = new javax.swing.GroupLayout(panelBorder5);
        panelBorder5.setLayout(panelBorder5Layout);
        panelBorder5Layout.setHorizontalGroup(
            panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sl_ctpn_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(luu_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(xong_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelBorder5Layout.createSequentialGroup()
                .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(screach1, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBorder5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(table_Sach, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 61, Short.MAX_VALUE)))
        );
        panelBorder5Layout.setVerticalGroup(
            panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder5Layout.createSequentialGroup()
                .addComponent(screach1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xong_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sl_ctpn_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(luu_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
            .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBorder5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(table_Sach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 250, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout ThemSachCuLayout = new javax.swing.GroupLayout(ThemSachCu.getContentPane());
        ThemSachCu.getContentPane().setLayout(ThemSachCuLayout);
        ThemSachCuLayout.setHorizontalGroup(
            ThemSachCuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThemSachCuLayout.createSequentialGroup()
                .addComponent(panelBorder5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        ThemSachCuLayout.setVerticalGroup(
            ThemSachCuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder5, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout KiemTraLayout = new javax.swing.GroupLayout(KiemTra.getContentPane());
        KiemTra.getContentPane().setLayout(KiemTraLayout);
        KiemTraLayout.setHorizontalGroup(
            KiemTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        KiemTraLayout.setVerticalGroup(
            KiemTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setLayout(new java.awt.CardLayout());

        main.setBackground(new Color(0,0,0,0));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        manv_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder1.add(manv_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 90, 50));

        ngaynhap_txt.setEditable(false);
        ngaynhap_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder1.add(ngaynhap_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, 230, 50));

        maphieunhap_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder1.add(maphieunhap_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 90, 50));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(150, 150, 150));
        jLabel6.setText("Ngày nhập");
        panelBorder1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 74, 70, -1));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
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
        panelBorder1.add(chooseDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 70, 30, 30));

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

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(150, 150, 150));
        jLabel13.setText("Mã nhân viên");
        panelBorder1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 74, 80, 20));

        ChonNCC.setLabeText("Nhà cung cấp");
        panelBorder1.add(ChonNCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 400, 40));

        nhapsachmoi_btn.setBackground(Color.decode("#00abfd"));
        nhapsachmoi_btn.setForeground(new java.awt.Color(255, 255, 255));
        nhapsachmoi_btn.setText("Nhập Sách Mới");
        nhapsachmoi_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhapsachmoi_btnActionPerformed(evt);
            }
        });
        panelBorder1.add(nhapsachmoi_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 130, -1));

        kiemtra_btn.setBackground(Color.decode("#00abfd"));
        kiemtra_btn.setForeground(new java.awt.Color(255, 255, 255));
        kiemtra_btn.setText("Chi Tiết  Nhập");
        kiemtra_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kiemtra_btnActionPerformed(evt);
            }
        });
        panelBorder1.add(kiemtra_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 110, -1));

        nhapsachcu_btn.setBackground(Color.decode("#00abfd"));
        nhapsachcu_btn.setForeground(new java.awt.Color(255, 255, 255));
        nhapsachcu_btn.setText("Chọn Sách");
        nhapsachcu_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhapsachcu_btnActionPerformed(evt);
            }
        });
        panelBorder1.add(nhapsachcu_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 130, -1));

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(main, "card2");

        chitiet.setBackground(new Color(0,0,0,0));

        table_ChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã chi tiết phiếu", "Mã sách", "Tên sách", "Tác giả", "Số lượng"
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

        tensach_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder2.add(tensach_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 290, 50));

        tentacgia_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder2.add(tentacgia_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 290, 50));

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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        date.setTextRefernce(ngaynhap_txt);
        date.toDay();
        maphieunhap_txt.setText(Integer.toString(phieuNhap_BUS.getNewID()));
        
        
        
        manv_txt.setText(Integer.toString(nv.getMaNV()));
        manv_txt.setEnabled(false);
        manv_txt.setEditable(false);
        
        ngaynhap_txt.setEnabled(true);
        chooseDate.setEnabled(true);
        ChonNCC.setEnabled(true);
        ChonNCC.setSelectedIndex(-1);

        
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
            mancc = nhaCungCap_BUS.getMaNCC(ChonNCC.getSelectedItem().toString());
            manv = Integer.parseInt(manv_txt.getText());
            date = phieuNhap_BUS.FormatDateSQL(ngaynhap_txt.getText());
            
        } catch (Exception e) {
            checked = false;
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
            "Dữ liệu không đúng định dạng.");
        }
        
        if (checked){  
            if (RowSelected == -1 && phieunhap == null) {
                
                if (arrayListSach != null) {
                    
                    phieunhap = new PhieuNhap(mapn, mancc, manv, date);
                    
                    if (phieuNhap_BUS.ThemPhieuNhap(phieunhap)) {

                        for (Sach sach1 : arrayListSach) {
                            System.out.println(sach_BUS.ThemSach(sach1));
                        }

                        table_PhieuNhap.addRow(new Object[]{mapn, mancc, manv, phieuNhap_BUS.FormatDate(date)});

                    }
                    Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT,
                            "Thêm phiếu nhập thành công.");
                    
                    
                    arrayListSach = null;
                } else {
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
                            "Vui lòng thêm sách.");
                }

                
                

        }   }
    }//GEN-LAST:event_save_btn_PNActionPerformed

    private void chooseDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseDateActionPerformed
        //DateChooser date = new DateChooser();
        date.setTextRefernce(ngaynhap_txt);
        date.showPopup(chooseDate, - 186, -50);
    }//GEN-LAST:event_chooseDateActionPerformed

    
    private void ThemChiTietPhieuNhap(PhieuNhap pn){
        int maPN_CTPN = pn.getMaPhieuNhap();
        int maCTPN = chiTietPhieuNhap_BUS.getNewID();
        ArrayList<Integer> masach_CTPN = masachList;
        int sl_CTPN ;
        
    }
    
    
    
    private void chitiet_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chitiet_btnActionPerformed
        
        
      
        if (RowSelected != -1 && phieunhap != null) {      
            try {

                int mapn = phieunhap.getMaPhieuNhap();
                
                ctpnBUS = new CTPNBUS(mapn);
                
                ctpnBUS.ReRenderCTPN(table_ChiTiet);
                
                table_ChiTiet.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                table_ChiTiet.setRowSelectionInterval(0, 0);

                ctpnDTO = ctpnBUS.SelectedCTPN(Integer.parseInt(table_ChiTiet.getModel().
                        getValueAt(0, 0).toString()));
                
        
                tensach_txt.setText(sach_BUS.getTenSach(ctpnDTO.getMaSach()));
                tensach_txt.setEnabled(false);

                card.next(this);
                    
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

    
    private void KiemTraSach(){ 
        
        
        
        boolean checked = false;
        
        int soluong = -1;
        int masach = -1;
        int maloaisach = -1;
        int manxb = -1;
        int matacgia = -1;
        
        String tensach = "";
        LocalDate date = LocalDate.now();
        
        String hinhanh = "default.svg";
        
            try {

                soluong = Integer.parseInt(sl_txt.getText());
                masach = Integer.parseInt(ms_txt.getText());
                maloaisach = loaiSach_BUS.getMaloaiSach(ChonTheLoai.getSelectedItem().toString());
                manxb = nhaXuatBan_BUS.getManhaxuatban(ChonNXB.getSelectedItem().toString());
                matacgia = tacGia_BUS.getMatacgia(ChonTG.getSelectedItem().toString());
                tensach = ts_txt.getText();
                date = sach_BUS.FormatDateSQL(nxb_txt.getText());
               
                
//                if (isChoosed) {
//                    String path = ch.getSelectedFile().toString();
//                    hinhanh = path.substring(path.lastIndexOf("\\"  ) + 1);
//                    isChoosed = false;
//                }else {
//                    if (sach == null) {
//                        hinhanh = "default.svg";
//                    }else{
//                        hinhanh = sach.getImgSach();
//                    }
//                }
                
                
                if (isSelectedIMG == JFileChooser.APPROVE_OPTION) {
                    
                    fileChooser = new JFileChooser();
                    File selectedFile = fileChooser.getSelectedFile();
                    String fileName=null;
                    if (selectedFile != null) { fileName= selectedFile.getName();
                        hinhanh = fileName; 
                    } 
                    System.out.println("check filename: " + fileName);
                    isSelectedIMG = -99;
                }
                


                checked = true;
                
                } catch (Exception e) {
                    checked = false;
                    
                    System.out.println(e);
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, 
                    "Dữ liệu không đúng định dạng.");
                }
        if (checked){  
           
            sach = new Sach(masach, tensach, hinhanh, maloaisach, manxb, matacgia, date, soluong, "");
            if (sach != null) {

                arrayListSach.add(sach);
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, 
                    "Thêm sách thành công.");
                setDefault();

            }
        
        }
        
    }                    
        
        
        
        
    






    private void nhapsachmoi_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhapsachmoi_btnActionPerformed
        
        arrayListSach = new ArrayList<Sach>();
        Dimension panelSize = this.getSize();
        
        Dimension dialogSize = ThemSachMoi.getSize();
        Point panelLocation = this.getLocationOnScreen();

        int x = panelLocation.x + (panelSize.width - dialogSize.width) / 2;
        int y = panelLocation.y + (panelSize.height - dialogSize.height) / 2;
        ThemSachMoi.setLocation(x, y);        
        
        setDefault();
 
        ThemSachMoi.setVisible(true);
    }//GEN-LAST:event_nhapsachmoi_btnActionPerformed

    private void setDefault(){
        nhaXuatBan_BUS.ChonNXB(ChonNXB);
        tacGia_BUS.ChonTG(ChonTG);
        loaiSach_BUS.ChonLoaiSach(ChonTheLoai);
        
        ChonNXB.setSelectedIndex(-1);
        ChonTG.setSelectedIndex(-1);
        ChonTheLoai.setSelectedIndex(-1);
        
        ms_txt.setText(Integer.toString(sach_BUS.getNewID()));
        
        ts_txt.setText("");
        sl_txt.setText("");
        nxb_txt.setText("");
        IMG.setIcon(defaultIMG);
    }
    
    
    private void kiemtra_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kiemtra_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kiemtra_btnActionPerformed

    public ArrayList<Integer> getMasachWithTrueBoolean(Table table) {
        ArrayList<Integer> masachList = new ArrayList<>();
        int booleanColumnIndex = 3; // Chỉ số của cột boolean (tính từ 0)
        int masachColumnIndex = 0; // Chỉ số của cột mã sách

        DefaultTableModel model = (DefaultTableModel) tb_sach.getModel();
        int rowCount = model.getRowCount();

        for (int row = 0; row < rowCount; row++) {
            Object booleanValue = model.getValueAt(row, booleanColumnIndex);
            if (booleanValue instanceof Boolean && (Boolean) booleanValue) {
                int masachValue = (Integer) model.getValueAt(row, masachColumnIndex);
                masachList.add(masachValue);
            }
        }

        return masachList;
    }
    
    
    
    
    private void nhapsachcu_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhapsachcu_btnActionPerformed
        Dimension panelSize = this.getSize();
        
        Dimension dialogSize = ThemSachCu.getSize();
        Point panelLocation = this.getLocationOnScreen();

        int x = panelLocation.x + (panelSize.width - dialogSize.width) / 2;
        int y = panelLocation.y + (panelSize.height - dialogSize.height) / 2;
        ThemSachCu.setLocation(x, y);        
        
        ArrayList<Sach> as = sach_BUS.getAll();
        
        for (Sach a : as) {
            String ts = a.getTenSach();
            int ms = a.getMaSach();
            String ttg = tacGia_BUS.getTTG(a.getMaTacGia());
            tb_sach.addRow(new Object[] {ms, ts, ttg});
        }
       
        
        screach1.TimKiem(tb_sach);
        
        
        
 
        ThemSachCu.setVisible(true);
    }//GEN-LAST:event_nhapsachcu_btnActionPerformed

    private void ChonTGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChonTGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChonTGActionPerformed

    private void chooseDate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseDate1ActionPerformed
        DateChooser date = new DateChooser();
        date.setTextRefernce(nxb_txt);
        date.showPopup(chooseDate1, - 186, -6);

    }//GEN-LAST:event_chooseDate1ActionPerformed

    private void ChooseIMGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChooseIMGActionPerformed
        //        ch = new JnaFileChooser();
        //        isChoosed = ch.showOpenDialog(main);
        //        if (isChoosed) {
            //            String imagePath = ch.getSelectedFile().toString();
            //            String path = imagePath.substring(imagePath.lastIndexOf("\\"  ) + 1);
                //
                //            System.out.println("check: " + path  + " ---- "  + imagePath  );
                //            if (path.equals("default.svg")) {
                    //                IMG.setIcon(defaultIMG);
                    //            }else{
                    //                IMG.setIcon(new HighRE().setIconJPG(path, "Sach"));
                    //            }
                //        }
            fileChooser = new JFileChooser();

            // Chỉ cho phép chọn các file ảnh
            fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
                @Override
                public boolean accept(File f) {
                    return f.isDirectory() || f.getName().toLowerCase().endsWith(".png")
                    || f.getName().toLowerCase().endsWith(".jpg")
                    || f.getName().toLowerCase().endsWith(".jpeg");
                }

                @Override
                public String getDescription() {
                    return "Image Files (*.png, *.jpg, *.jpeg)";
                }
            });

            // Mở hộp thoại chọn file
            isSelectedIMG = fileChooser.showOpenDialog(main);

            // Nếu người dùng chọn ảnh
            if (isSelectedIMG == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                String fileName = selectedFile.getName();

                // Lấy đường dẫn thư mục "images" trong resources
                URL resourceUrl = getClass().getClassLoader().getResource("IMG/Sach");
                if (resourceUrl == null) {
                    System.err.println("Thư mục images không tồn tại trong resources!");
                    return;
                }

                File destinationFolder = new File(resourceUrl.getPath());

                // Tạo file đích trong thư mục resources
                File destinationFile = new File(destinationFolder, fileName);

                try {
                    // Sao chép file ảnh vào thư mục trong resources
                   
                    Files.copy(selectedFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

                    // Hiển thị ảnh lên JLabel
                    ImageIcon imageIcon = new ImageIcon(destinationFile.getAbsolutePath());

                    IMG.setIcon(imageIcon);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
    }//GEN-LAST:event_ChooseIMGActionPerformed

    private void xong_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xong_btnActionPerformed

        KiemTraSach();

        ThemSachMoi.dispose();
    }//GEN-LAST:event_xong_btnActionPerformed

    private void nhaptiep_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhaptiep_btnActionPerformed
        KiemTraSach();
        ChonNXB.setSelectedIndex(-1);
        ChonTG.setSelectedIndex(-1);
        ChonTheLoai.setSelectedIndex(-1);
        id++;
        ms_txt.setText(Integer.toString(id));
        
        ts_txt.setText("");
        sl_txt.setText("");
        nxb_txt.setText("");
        IMG.setIcon(defaultIMG);
    }//GEN-LAST:event_nhaptiep_btnActionPerformed

    private void ms_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ms_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ms_txtActionPerformed

    private void jScrollPaneMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jScrollPaneMouseWheelMoved
   
    }//GEN-LAST:event_jScrollPaneMouseWheelMoved

    private void xong_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xong_btn1ActionPerformed
        masachList = getMasachWithTrueBoolean(tb_sach);

        
        
        
        ThemSachCu.dispose();

    }//GEN-LAST:event_xong_btn1ActionPerformed

    private void sl_ctpn_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sl_ctpn_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sl_ctpn_txtActionPerformed

    private void luu_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_luu_btnActionPerformed
        
        
        
        
    }//GEN-LAST:event_luu_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.UIComponents.Combobox ChonNCC;
    private GUI.UIComponents.Combobox ChonNXB;
    private GUI.UIComponents.Combobox ChonTG;
    private GUI.UIComponents.Combobox ChonTheLoai;
    private GUI.UIComponents.Button ChooseIMG;
    private javax.swing.JLabel IMG;
    private javax.swing.JDialog KiemTra;
    private javax.swing.JDialog ThemSachCu;
    private javax.swing.JDialog ThemSachMoi;
    private GUI.UIComponents.Button add_btn2;
    private GUI.UIComponents.Button add_btn_PN;
    private GUI.UIComponents.Button back;
    private GUI.UIComponents.Button back1;
    private javax.swing.JPanel chitiet;
    private GUI.UIComponents.Button chitiet_btn;
    private GUI.UIComponents.Button chooseDate;
    private GUI.UIComponents.Button chooseDate1;
    private GUI.UIComponents.Button delete_btn2;
    private GUI.UIComponents.Button delete_btn_PN;
    private GUI.UIComponents.Button export_PN;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jlabel;
    private javax.swing.JLabel jlabell1;
    private GUI.UIComponents.Button kiemtra_btn;
    private GUI.UIComponents.Button luu_btn;
    private javax.swing.JPanel main;
    private GUI.UIComponents.TextField mancc_NCC_txt;
    private GUI.UIComponents.TextField manv_txt;
    private GUI.UIComponents.TextField maphieunhap_txt;
    private GUI.UIComponents.TextField ms_txt;
    private javax.swing.JPanel ncc;
    private GUI.UIComponents.TextField ngaynhap_txt;
    private GUI.UIComponents.Button nhacungcap_btn;
    private GUI.UIComponents.Button nhapsachcu_btn;
    private GUI.UIComponents.Button nhapsachmoi_btn;
    private GUI.UIComponents.Button nhaptiep_btn;
    private GUI.UIComponents.TextField nxb_txt;
    private GUI.UIComponents.Panel.PanelBorder panelBorder1;
    private GUI.UIComponents.Panel.PanelBorder panelBorder2;
    private GUI.UIComponents.Panel.PanelBorder panelBorder3;
    private GUI.UIComponents.Panel.PanelBorder panelBorder4;
    private GUI.UIComponents.Panel.PanelBorder panelBorder5;
    private GUI.UIComponents.Button save_btn2;
    private GUI.UIComponents.Button save_btn_PN;
    private GUI.UIComponents.Screach screach1;
    private GUI.UIComponents.TextField sl_ctpn_txt;
    private GUI.UIComponents.TextField sl_txt;
    private GUI.UIComponents.Table.Table table_ChiTiet;
    private GUI.UIComponents.Table.Table table_NCC;
    private GUI.UIComponents.Table.Table table_PhieuNhap;
    private GUI.UIComponents.Table.Table table_Sach;
    private GUI.UIComponents.Table.Table tb_sach;
    private GUI.UIComponents.TextField tennc_NCC_txt;
    private GUI.UIComponents.TextField tensach_txt;
    private GUI.UIComponents.TextField tentacgia_txt;
    private GUI.UIComponents.TextField ts_txt;
    private GUI.UIComponents.Button xong_btn;
    private GUI.UIComponents.Button xong_btn1;
    // End of variables declaration//GEN-END:variables
}
