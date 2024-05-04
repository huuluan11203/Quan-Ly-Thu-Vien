
package GUI.UIComponents;

import BUS.ChiTietPhieuMuon_BUS;
import BUS.PhieuMuon_BUS;
import BUS.PhieuPhat_BUS;
import BUS.Sach_BUS;
import DTO.ChiTietPhieuMuon;
import DTO.PhieuMuon;
import DTO.PhieuPhat;
import GUI.UIComponents.DATE.DateChooser;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.CardLayout;
import java.awt.Color;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import raven.toast.Notifications;

//Quá hạn 3 ngày 10000
//Quá hạn 10 ngày 30000
//Quá hạn 20 ngày 60000
//Quá hạn >20 ngày 100000 | + 100000 cho mỗi tháng tiếp theo

public class Form_MuonSach extends javax.swing.JPanel {
    CardLayout card;
    private int RowSelected = -1;
    private static Sach_BUS sach_BUS;
    private static PhieuMuon phieumuon;
    private static PhieuPhat phieuphat;
    private static PhieuPhat_BUS phieuPhat_BUS;
    private static PhieuMuon_BUS phieuMuon_BUS;
    private static ChiTietPhieuMuon ctpm;
    private static ChiTietPhieuMuon_BUS chiTietPhieuMuon_BUS;
    
    public Form_MuonSach() {
        initComponents();
        
        phieuMuon_BUS = new PhieuMuon_BUS();
        chiTietPhieuMuon_BUS = new ChiTietPhieuMuon_BUS();
        phieuPhat_BUS = new PhieuPhat_BUS();
        sach_BUS = new Sach_BUS();
        
        card = (CardLayout) this.getLayout();
        card.show(Form_MuonSach.this, "PhieuMuon");
        
        ChonTinhTrang.setSelectedIndex(-1);
        
        phieuMuon_BUS.RenderPhieuMuon(table_PM);
        table_PM.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        chiTietPhieuMuon_BUS.RenderCTPM(table_CTPM);
        table_CTPM.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        phieuPhat_BUS.RenderPhieuPhat(table_PhieuPhat);
        table_PhieuPhat.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        initEvent();
    }

    
    
    private void initEvent(){
        
        table_PM.addMouseListener(new java.awt.event.MouseAdapter() { // row is clicked
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    if (SwingUtilities.isLeftMouseButton(evt)) {
                        
                        RowSelected = table_PM.getSelectedRow();
                        phieumuon = phieuMuon_BUS.SelectedPhieuMuon(Integer.parseInt(table_PM.getModel().
                                getValueAt(RowSelected, 0).toString()));
                        
                        maphieumuon_txt.setText(Integer.toString(phieumuon.getMaPhieuMuon()));
                        maphieumuon_txt.setEnabled(false);
                        
                        madocgia_txt.setText(Integer.toString(phieumuon.getMaDocGia()));
                        manhanvien_txt.setText(Integer.toString(phieumuon.getMaNV()));
                        ngaymuon_txt.setText(phieuMuon_BUS.FormatDate(phieumuon.getNgayMuon()));
                        ChonTinhTrang.setSelectedItem(phieumuon.getTinhTrang());
                        if (phieumuon.getTinhTrang().equals("QUÁ HẠN")) {
                            phieuphat_btn.setEnabled(true);
                        }else{
                            phieuphat_btn.setEnabled(false);
                        }
                    }
                    
                }

            });
         
        table_PhieuPhat.addMouseListener(new java.awt.event.MouseAdapter() { // row is clicked
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    if (SwingUtilities.isLeftMouseButton(evt)) {
                        
                        RowSelected = table_PhieuPhat.getSelectedRow();
                        phieuphat = phieuPhat_BUS.SelectedPhieuPhat(Integer.parseInt(table_PhieuPhat.getModel().
                                getValueAt(RowSelected, 0).toString()));
                        mapp_txt.setText(Integer.toString(phieuphat.getMaPP()));
                        mapm_txt1.setText(Integer.toString(phieuphat.getMaPM()));
                        sotien_txt.setText(Integer.toString(phieuphat.getSoTien()));
                        ngayquahan_txt.setText(Long.toString(NgayQuaHan(phieuphat.getNgaytra(),phieuphat.getMaPM())));
                        ngaytra_txt1.setText(phieuPhat_BUS.FormatDate(phieuphat.getNgaytra()));
                        lydo_txt.setText(phieuphat.getLyDo());
                        mapp_txt.setEnabled(false);
                    }  
                    
                }

        });
        
        table_CTPM.addMouseListener(new java.awt.event.MouseAdapter() { // row is clicked
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    if (SwingUtilities.isLeftMouseButton(evt)) {
                        
                        RowSelected = table_CTPM.getSelectedRow();
                        ctpm = chiTietPhieuMuon_BUS.SelectedCTPM(Integer.parseInt(table_CTPM.getModel().
                                getValueAt(RowSelected, 0).toString()));
                        
                        maCTPM_txt.setText(Integer.toString(ctpm.getMaCTPM()));
                        mapm_txt.setText(Integer.toString(ctpm.getMaPhieuMuon()));
                        masach_txt.setText(Integer.toString(ctpm.getMaSach()));
                        ghichu_txt.setText(ctpm.getGhiChu());
                        tensach_txt.setText(sach_BUS.getTenSach(ctpm.getMaSach()));
                        ngaytra_txt.setText(chiTietPhieuMuon_BUS.FormatDate(ctpm.getNgayTra()));
                        maCTPM_txt.setEnabled(false);
                        tensach_txt.setEnabled(false);
                    }
                    
                }

        });
        
    
    }
    
   
    private long NgayQuaHan(LocalDate date, int ma){
        int positon = table_CTPM.find(ma, 1);                
        ctpm = chiTietPhieuMuon_BUS.SelectedCTPM(Integer.parseInt(table_CTPM.getModel().
                                getValueAt(positon, 0).toString()));
        long nqh = ctpm.getNgayTra().until(date, ChronoUnit.DAYS);
        return nqh;
    }
    
    private int TienPhat(long ngayquahan){
        if (ngayquahan <= 3) {
            return 10000;
        }else if (ngayquahan <= 10) {
            return 30000;
        }else if (ngayquahan <= 20) {
            return 60000;
        }else if (ngayquahan > 20) {
            return 100000;
        }
        return -1;
    }
    
    private void setToDefault(){
        
        RowSelected = -1;
        
        // Phieu Muon
        table_PM.clearSelection();
        maphieumuon_txt.setText("");
        maphieumuon_txt.setEnabled(true);
        ngaymuon_txt.setText("");
        madocgia_txt.setText("");
        manhanvien_txt.setText("");
        ChonTinhTrang.setSelectedIndex(-1);
        phieumuon = null;
      
        //phieu phat
        table_PhieuPhat.clearSelection();
        phieuphat_btn.setEnabled(true);
        mapp_txt.setText("");
        mapm_txt1.setText("");
        lydo_txt.setText("");
        ngayquahan_txt.setText("");
        ngaytra_txt1.setText("");
        phieuphat = null;
        sotien_txt.setText("");
        
        
        //CTPM
        table_CTPM.clearSelection();
        maCTPM_txt.setText("");
        maCTPM_txt.setEnabled(true);
        mapm_txt.setText("");
        masach_txt.setText("");
        tensach_txt.setText("");
        ghichu_txt.setText("");
        ngaytra_txt.setText("");
        ctpm = null;
        
               
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PhieuMuon = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_PM = new GUI.UIComponents.Table.Table();
        panelBorder1 = new GUI.UIComponents.Panel.PanelBorder();
        chitiet_btn = new GUI.UIComponents.Button();
        phieuphat_btn = new GUI.UIComponents.Button();
        save_btn_PM = new GUI.UIComponents.Button();
        add_btn_PM = new GUI.UIComponents.Button();
        delete_btn_PM = new GUI.UIComponents.Button();
        export_PN = new GUI.UIComponents.Button();
        jLabel7 = new javax.swing.JLabel();
        maphieumuon_txt = new GUI.UIComponents.TextField();
        ChonTinhTrang = new GUI.UIComponents.Combobox();
        ngaymuon_txt = new GUI.UIComponents.TextField();
        manhanvien_txt = new GUI.UIComponents.TextField();
        madocgia_txt = new GUI.UIComponents.TextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        chooseDate = new GUI.UIComponents.Button();
        CTPM = new javax.swing.JPanel();
        panelBorder3 = new GUI.UIComponents.Panel.PanelBorder();
        save_btn = new GUI.UIComponents.Button();
        add_btn = new GUI.UIComponents.Button();
        delete_btn = new GUI.UIComponents.Button();
        masach_txt = new GUI.UIComponents.TextField();
        jLabel11 = new javax.swing.JLabel();
        ngaytra_txt = new GUI.UIComponents.TextField();
        chooseDate1 = new GUI.UIComponents.Button();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        ghichu_txt = new GUI.UIComponents.TextField();
        mapm_txt = new GUI.UIComponents.TextField();
        tensach_txt = new GUI.UIComponents.TextField();
        maCTPM_txt = new GUI.UIComponents.TextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        back3 = new GUI.UIComponents.Button();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_CTPM = new GUI.UIComponents.Table.Table();
        PhieuPhat = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_PhieuPhat = new GUI.UIComponents.Table.Table();
        panelBorder2 = new GUI.UIComponents.Panel.PanelBorder();
        save_btn1 = new GUI.UIComponents.Button();
        add_btn1 = new GUI.UIComponents.Button();
        delete_btn1 = new GUI.UIComponents.Button();
        back4 = new GUI.UIComponents.Button();
        mapp_txt = new GUI.UIComponents.TextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        ngaytra_txt1 = new GUI.UIComponents.TextField();
        jLabel23 = new javax.swing.JLabel();
        chooseDate2 = new GUI.UIComponents.Button();
        mapm_txt1 = new GUI.UIComponents.TextField();
        lydo_txt = new GUI.UIComponents.TextField();
        ngayquahan_txt = new GUI.UIComponents.TextField();
        jLabel24 = new javax.swing.JLabel();
        sotien_txt = new GUI.UIComponents.TextField();
        jLabel25 = new javax.swing.JLabel();

        setBackground(new Color(0,0,0,0));
        setMaximumSize(new java.awt.Dimension(802, 645));
        setLayout(new java.awt.CardLayout());

        PhieuMuon.setBackground(new Color(0,0,0,0));
        PhieuMuon.setMaximumSize(new java.awt.Dimension(802, 645));

        table_PM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Phiếu Mượn", "Mã Nhân Viên", "Mã Độc Giả", "Ngày Mượn", "Tình Trạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_PM.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(table_PM);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        chitiet_btn.setBackground(Color.decode("#00abfd"));
        chitiet_btn.setForeground(new java.awt.Color(255, 255, 255));
        chitiet_btn.setText("Chi Tiết ");
        chitiet_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chitiet_btnActionPerformed(evt);
            }
        });
        panelBorder1.add(chitiet_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        phieuphat_btn.setBackground(Color.decode("#00abfd"));
        phieuphat_btn.setForeground(new java.awt.Color(255, 255, 255));
        phieuphat_btn.setText("Phiếu Phạt");
        phieuphat_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phieuphat_btnActionPerformed(evt);
            }
        });
        panelBorder1.add(phieuphat_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        save_btn_PM.setIcon(new FlatSVGIcon("IMG/icon/save.svg",30,30));
        save_btn_PM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_btn_PMActionPerformed(evt);
            }
        });
        panelBorder1.add(save_btn_PM, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 6, 41, 42));

        add_btn_PM.setIcon(new FlatSVGIcon("IMG/icon/add.svg",30,30));
        add_btn_PM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btn_PMActionPerformed(evt);
            }
        });
        panelBorder1.add(add_btn_PM, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 6, 41, 42));

        delete_btn_PM.setIcon(new FlatSVGIcon("IMG/icon/delete.svg",30,30));
        delete_btn_PM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btn_PMActionPerformed(evt);
            }
        });
        panelBorder1.add(delete_btn_PM, new org.netbeans.lib.awtextra.AbsoluteConstraints(458, 6, 41, 42));

        export_PN.setBackground(new Color(0,0,0,0)
        );
        export_PN.setIcon(new FlatSVGIcon("IMG/icon/excel.svg",40,40)
        );
        panelBorder1.add(export_PN, new org.netbeans.lib.awtextra.AbsoluteConstraints(754, 10, 40, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(150, 150, 150));
        jLabel7.setText("Mã độc giả");
        panelBorder1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 174, 90, -1));

        maphieumuon_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        maphieumuon_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maphieumuon_txtActionPerformed(evt);
            }
        });
        panelBorder1.add(maphieumuon_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 240, 50));

        ChonTinhTrang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ĐÃ TRẢ", "QUÁ HẠN", "ĐANG MƯỢN" }));
        ChonTinhTrang.setSelectedIndex(-1);
        ChonTinhTrang.setLabeText("Tình trạng");
        ChonTinhTrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChonTinhTrangActionPerformed(evt);
            }
        });
        panelBorder1.add(ChonTinhTrang, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 310, 40));

        ngaymuon_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        ngaymuon_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ngaymuon_txtActionPerformed(evt);
            }
        });
        panelBorder1.add(ngaymuon_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 210, 50));

        manhanvien_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder1.add(manhanvien_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 240, 50));

        madocgia_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        madocgia_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                madocgia_txtActionPerformed(evt);
            }
        });
        panelBorder1.add(madocgia_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 240, 50));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(150, 150, 150));
        jLabel8.setText("Ngày mượn");
        panelBorder1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 173, 70, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(150, 150, 150));
        jLabel9.setText("Mã phiếu mượn");
        panelBorder1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 74, 90, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(150, 150, 150));
        jLabel10.setText("Mã nhân viên");
        panelBorder1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 124, 90, -1));

        chooseDate.setBackground(new Color(0,0,0,0));
        chooseDate.setIcon(new FlatSVGIcon("IMG/icon/calendar.svg",30,30));
        chooseDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseDateActionPerformed(evt);
            }
        });
        panelBorder1.add(chooseDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 170, 30, 30));

        javax.swing.GroupLayout PhieuMuonLayout = new javax.swing.GroupLayout(PhieuMuon);
        PhieuMuon.setLayout(PhieuMuonLayout);
        PhieuMuonLayout.setHorizontalGroup(
            PhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PhieuMuonLayout.setVerticalGroup(
            PhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PhieuMuonLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(PhieuMuon, "card4");

        CTPM.setBackground(new Color(0,0,0,0));

        panelBorder3.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        save_btn.setIcon(new FlatSVGIcon("IMG/icon/save.svg",30,30));
        save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_btnActionPerformed(evt);
            }
        });
        panelBorder3.add(save_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 6, 41, 42));

        add_btn.setIcon(new FlatSVGIcon("IMG/icon/add.svg",30,30));
        add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btnActionPerformed(evt);
            }
        });
        panelBorder3.add(add_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 6, 41, 42));

        delete_btn.setIcon(new FlatSVGIcon("IMG/icon/delete.svg",30,30));
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });
        panelBorder3.add(delete_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(458, 6, 41, 42));

        masach_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder3.add(masach_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 240, 50));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(150, 150, 150));
        jLabel11.setText("Mã sách");
        panelBorder3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 174, 90, -1));

        ngaytra_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        ngaytra_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ngaytra_txtActionPerformed(evt);
            }
        });
        panelBorder3.add(ngaytra_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 210, 50));

        chooseDate1.setBackground(new Color(0,0,0,0));
        chooseDate1.setIcon(new FlatSVGIcon("IMG/icon/calendar.svg",30,30));
        chooseDate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseDate1ActionPerformed(evt);
            }
        });
        panelBorder3.add(chooseDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 170, 30, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(150, 150, 150));
        jLabel13.setText("Mã phiếu mượn");
        panelBorder3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 124, 90, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(150, 150, 150));
        jLabel14.setText("Mã CTPM");
        panelBorder3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 74, 90, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(150, 150, 150));
        jLabel15.setText("Tên sách");
        panelBorder3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 125, 70, -1));

        ghichu_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder3.add(ghichu_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 240, 50));

        mapm_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder3.add(mapm_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 240, 50));

        tensach_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder3.add(tensach_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 240, 50));

        maCTPM_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder3.add(maCTPM_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 240, 50));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(150, 150, 150));
        jLabel16.setText("Ghi chú");
        panelBorder3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 74, 70, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(150, 150, 150));
        jLabel18.setText("Ngày trả");
        panelBorder3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 173, 70, -1));

        back3.setBackground(Color.decode("#00abfd"));
        back3.setForeground(new java.awt.Color(255, 255, 255));
        back3.setIcon(new FlatSVGIcon("IMG/icon/back.svg",15,15)
        );
        back3.setText("Trở Lại");
        back3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back3ActionPerformed(evt);
            }
        });
        panelBorder3.add(back3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        table_CTPM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Chi Tiết Phiếu Mượn", "Mã Phiếu Mượn", "Mã Sách", "Ngày Trả", "Ghi Chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_CTPM.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jScrollPane3.setViewportView(table_CTPM);

        javax.swing.GroupLayout CTPMLayout = new javax.swing.GroupLayout(CTPM);
        CTPM.setLayout(CTPMLayout);
        CTPMLayout.setHorizontalGroup(
            CTPMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addComponent(panelBorder3, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
        );
        CTPMLayout.setVerticalGroup(
            CTPMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CTPMLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder3, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
        );

        add(CTPM, "card3");

        PhieuPhat.setBackground(new Color(0,0,0,0));
        PhieuPhat.setPreferredSize(new java.awt.Dimension(802, 645));

        table_PhieuPhat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Phiếu Phạt", "Mã Phiếu Mượn", "Ngày Trả", "Lý Do", "Số Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_PhieuPhat.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jScrollPane2.setViewportView(table_PhieuPhat);

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        save_btn1.setIcon(new FlatSVGIcon("IMG/icon/save.svg",30,30));
        save_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_btn1ActionPerformed(evt);
            }
        });
        panelBorder2.add(save_btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 6, 41, 42));

        add_btn1.setIcon(new FlatSVGIcon("IMG/icon/add.svg",30,30));
        add_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btn1ActionPerformed(evt);
            }
        });
        panelBorder2.add(add_btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 6, 41, 42));

        delete_btn1.setIcon(new FlatSVGIcon("IMG/icon/delete.svg",30,30));
        delete_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btn1ActionPerformed(evt);
            }
        });
        panelBorder2.add(delete_btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(458, 6, 41, 42));

        back4.setBackground(Color.decode("#00abfd"));
        back4.setForeground(new java.awt.Color(255, 255, 255));
        back4.setIcon(new FlatSVGIcon("IMG/icon/back.svg",15,15)
        );
        back4.setText("Trở Lại");
        back4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back4ActionPerformed(evt);
            }
        });
        panelBorder2.add(back4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        mapp_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        mapp_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mapp_txtActionPerformed(evt);
            }
        });
        panelBorder2.add(mapp_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 240, 50));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(150, 150, 150));
        jLabel19.setText("Lý do");
        panelBorder2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 174, 90, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(150, 150, 150));
        jLabel20.setText("Mã phiếu phạt");
        panelBorder2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 74, 90, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(150, 150, 150));
        jLabel21.setText("Mã phiếu mượn");
        panelBorder2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 124, 90, -1));

        ngaytra_txt1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder2.add(ngaytra_txt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 200, 50));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(150, 150, 150));
        jLabel23.setText("Ngày quá hạn");
        panelBorder2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 74, 80, -1));

        chooseDate2.setBackground(new Color(0,0,0,0));
        chooseDate2.setIcon(new FlatSVGIcon("IMG/icon/calendar.svg",30,30));
        chooseDate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseDate2ActionPerformed(evt);
            }
        });
        panelBorder2.add(chooseDate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 170, 30, 30));

        mapm_txt1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder2.add(mapm_txt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 240, 50));

        lydo_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        panelBorder2.add(lydo_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 240, 50));

        ngayquahan_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        ngayquahan_txt.setHint("");
        panelBorder2.add(ngayquahan_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 230, 50));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(150, 150, 150));
        jLabel24.setText("Ngày trả");
        panelBorder2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 173, 70, -1));

        sotien_txt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        sotien_txt.setHint("");
        panelBorder2.add(sotien_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, 230, 50));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(150, 150, 150));
        jLabel25.setText("Số tiền");
        panelBorder2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 124, 70, -1));

        javax.swing.GroupLayout PhieuPhatLayout = new javax.swing.GroupLayout(PhieuPhat);
        PhieuPhat.setLayout(PhieuPhatLayout);
        PhieuPhatLayout.setHorizontalGroup(
            PhieuPhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
            .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PhieuPhatLayout.setVerticalGroup(
            PhieuPhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PhieuPhatLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
        );

        add(PhieuPhat, "card4");
    }// </editor-fold>//GEN-END:initComponents

    private void chitiet_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chitiet_btnActionPerformed

        if (RowSelected != -1 && phieumuon != null) {
            try {

                int mapm = phieumuon.getMaPhieuMuon();
                RowSelected = table_CTPM.find(mapm, 1);

                if (RowSelected != -1) {
                    table_CTPM.setRowSelectionInterval(RowSelected, RowSelected);

                    ctpm = chiTietPhieuMuon_BUS.SelectedCTPM(Integer.parseInt(table_CTPM.getModel().
                        getValueAt(RowSelected, 0).toString()));
                    maCTPM_txt.setText(Integer.toString(ctpm.getMaCTPM()));
                    maCTPM_txt.setEnabled(false);
                    
                    mapm_txt.setText(Integer.toString(ctpm.getMaPhieuMuon()));
                    masach_txt.setText(Integer.toString(ctpm.getMaSach()));
                    tensach_txt.setEnabled(false);
                    tensach_txt.setText(sach_BUS.getTenSach(ctpm.getMaSach()));
                    ghichu_txt.setText(ctpm.getGhiChu());
                    ngaytra_txt.setText(chiTietPhieuMuon_BUS.FormatDate(ctpm.getNgayTra()));

                    card.next(this);
                }

            } catch (NullPointerException e) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
                    "Chi tiết phiếu mượn không tồn tại.");

            } catch (IllegalArgumentException e){
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
                    "Chi tiết phiếu mượn không tồn tại.");
            }

        }else {
            
            card.next(this);
        }

    }//GEN-LAST:event_chitiet_btnActionPerformed

    private void phieuphat_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phieuphat_btnActionPerformed
        if (RowSelected != -1 && phieumuon != null){
            

            int mapm = phieumuon.getMaPhieuMuon();
            RowSelected = table_PhieuPhat.find(mapm, 1);

            if (RowSelected != -2) {
                table_PhieuPhat.setRowSelectionInterval(RowSelected, RowSelected);

                phieuphat = phieuPhat_BUS.SelectedPhieuPhat(Integer.parseInt(table_PhieuPhat.getModel().
                    getValueAt(RowSelected, 0).toString()));

                mapp_txt.setText(Integer.toString(phieuphat.getMaPP()));
                mapm_txt1.setText(Integer.toString(phieuphat.getMaPM()));
                sotien_txt.setText(Integer.toString(phieuphat.getSoTien()));
                ngayquahan_txt.setText(Long.toString(NgayQuaHan(phieuphat.getNgaytra(), phieuphat.getMaPM())));
                ngaytra_txt1.setText(phieuPhat_BUS.FormatDate(phieuphat.getNgaytra()));
                lydo_txt.setText(phieuphat.getLyDo());
                mapp_txt.setEnabled(false);

                card.last(this);
            }else {
                RowSelected = -1;
                table_PhieuPhat.clearSelection();
                mapp_txt.setText("");
                mapp_txt.setEnabled(true);
                mapm_txt1.setText(Integer.toString(phieumuon.getMaPhieuMuon()));
                lydo_txt.setText("");
                ngayquahan_txt.setText(Long.toString(NgayQuaHan(LocalDate.now(), phieumuon.getMaPhieuMuon())));
                ngaytra_txt1.setText(phieuPhat_BUS.FormatDate(LocalDate.now()));
                sotien_txt.setText(Long.toString(TienPhat(NgayQuaHan(LocalDate.now(), phieumuon.getMaPhieuMuon()))));
                card.last(this);
                ctpm = null;
            }   
           
        }else{
           
            card.last(this);
        }
        
    }//GEN-LAST:event_phieuphat_btnActionPerformed


    private void save_btn_PMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btn_PMActionPerformed

        boolean checked = false;
        int mapm = -1;
        int madocgia = -1;
        int manv = -1;
        String tinhtrang = "";
        LocalDate date = LocalDate.now();
        try {
            checked = true;
            mapm = Integer.parseInt(maphieumuon_txt.getText());
            madocgia = Integer.parseInt(madocgia_txt.getText());
            manv = Integer.parseInt(manhanvien_txt.getText());
            date = phieuMuon_BUS.FormatDateSQL(ngaymuon_txt.getText());
            tinhtrang = ChonTinhTrang.getSelectedItem().toString();

        } catch (Exception e) {
            checked = false;
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
                "Dữ liệu không đúng định dạng.");
        }

        if (checked){
            if (RowSelected == -1 && phieumuon == null) {

                phieumuon = new PhieuMuon(mapm, manv, madocgia, date, tinhtrang);

                if (phieuMuon_BUS.ThemPhieuMuon(phieumuon)) {
                    table_PM.addRow(new Object[] {mapm, manv, madocgia,phieuMuon_BUS.FormatDate(date), tinhtrang});
                }

                phieumuon = null;

            }else {
                PhieuMuon pmUpdate =  new PhieuMuon(mapm, manv, madocgia, date, tinhtrang);
                if (phieuMuon_BUS.SuaPhieuMuon(pmUpdate, phieumuon)) {

                    table_PM.updateRow(RowSelected, new Object[] {mapm, manv, madocgia,phieuMuon_BUS.FormatDate(date), tinhtrang});
                    phieumuon = pmUpdate;
                    if (phieumuon.getTinhTrang().equals("QUÁ HẠN")) {
                        phieuphat_btn.setEnabled(true);
                    }else{
                        phieuphat_btn.setEnabled(false);
                    }
                    pmUpdate = null;

                }
            }
        }
    }//GEN-LAST:event_save_btn_PMActionPerformed

    private void add_btn_PMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btn_PMActionPerformed
        setToDefault();
    }//GEN-LAST:event_add_btn_PMActionPerformed

    private void delete_btn_PMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btn_PMActionPerformed
        if (RowSelected != -1) {
            ImageIcon icon = new FlatSVGIcon("IMG/icon/warning.svg",30,30);
            String[] cf = {"Đồng ý", "Hủy"};
            int choice = JOptionPane.showOptionDialog(null,"Xóa phiếu mượn \"" + phieumuon.getMaPhieuMuon() +
                "\" ? \n Chi tiết phiếu mượn cũng sẽ bị xóa.","Xác Nhận",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, cf ,null);
            if (choice == 0) {

                if (phieuMuon_BUS.XoaPhieuMuon(phieumuon)) {
                    table_PM.deleteRow(RowSelected);
                    setToDefault();
                }
            }
        }else{
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
                "Vui lòng chọn phiếu mượn.");
        }
    }//GEN-LAST:event_delete_btn_PMActionPerformed

    private void ngaymuon_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ngaymuon_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ngaymuon_txtActionPerformed

    private void chooseDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseDateActionPerformed
        DateChooser date = new DateChooser();
        date.setTextRefernce(ngaymuon_txt);
        date.showPopup(chooseDate, - 186, -130);
    }//GEN-LAST:event_chooseDateActionPerformed

    private void save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btnActionPerformed

        boolean checked = false;

        int masach = -1;
        int mactpm = -1;
        int mapm = -1;
        String ghichu = "";
        LocalDate date = LocalDate.now();


        try {

            masach = Integer.parseInt(masach_txt.getText());
            mactpm = Integer.parseInt(maCTPM_txt.getText());
            mapm = Integer.parseInt(mapm_txt.getText());
            ghichu = ghichu_txt.getText();
            date = chiTietPhieuMuon_BUS.FormatDateSQL(ngaytra_txt.getText());
           
            checked = true;

            } catch (Exception e) {
                checked = false;
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
                    "Dữ liệu không đúng định dạng.");
            }
            if (checked){
                if (RowSelected == -1 && ctpm == null) {

                    ctpm = new ChiTietPhieuMuon(mactpm, mapm, masach, date, ghichu);

                    if (chiTietPhieuMuon_BUS.ThemCTPM(ctpm)) {

                        table_CTPM.addRow(new Object[] {mactpm, mapm, masach, chiTietPhieuMuon_BUS.FormatDate(date), ghichu});
                    }

                ctpm = null;

                }else {

                    ChiTietPhieuMuon ctpmUpdate = new ChiTietPhieuMuon(mactpm, mapm, masach, date, ghichu);

                    if (chiTietPhieuMuon_BUS.SuaCTPM(ctpmUpdate,ctpm)) {

                        table_CTPM.updateRow(RowSelected, new Object[]{mactpm, mapm, masach, chiTietPhieuMuon_BUS.FormatDate(date), ghichu});
                    }       
                    ctpm = ctpmUpdate;
                    ctpmUpdate = null;

                }
        }

    }//GEN-LAST:event_save_btnActionPerformed

    private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btnActionPerformed

        //remove data selected
        setToDefault();

    }//GEN-LAST:event_add_btnActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed

        if (RowSelected != -1) {
            ImageIcon icon = new FlatSVGIcon("IMG/icon/warning.svg",30,30);
            String[] cf = {"Đồng ý", "Hủy"};
            int choice = JOptionPane.showOptionDialog(null,"Xóa chi tiết phiếu mượn \"" + ctpm.getMaCTPM() +"\" ?","Xác Nhận",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, cf ,null);
            if (choice == 0) {

                if (chiTietPhieuMuon_BUS.XoaCTPM(ctpm)) {
                    table_CTPM.deleteRow(RowSelected);
                    setToDefault();

                }
            }
        }else{
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
                "Vui lòng chọn chi tiết phiếu mượn.");
        }

    }//GEN-LAST:event_delete_btnActionPerformed

    private void madocgia_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_madocgia_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_madocgia_txtActionPerformed

    private void maphieumuon_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maphieumuon_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maphieumuon_txtActionPerformed

    private void ChonTinhTrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChonTinhTrangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChonTinhTrangActionPerformed

    private void ngaytra_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ngaytra_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ngaytra_txtActionPerformed

    private void chooseDate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseDate1ActionPerformed
        DateChooser date = new DateChooser();
        date.setTextRefernce(ngaytra_txt);
        date.showPopup(chooseDate1, - 186, -130);
    }//GEN-LAST:event_chooseDate1ActionPerformed

    private void back3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back3ActionPerformed
        
        card.first(this);
    }//GEN-LAST:event_back3ActionPerformed

    private void save_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btn1ActionPerformed
        boolean checked = false;

        int mapp = -1;
        int sotien = -1;
        int mapm = -1;
        String lydo = "";
        LocalDate date = LocalDate.now();


        try {

            mapp = Integer.parseInt(mapp_txt.getText());
            sotien = Integer.parseInt(sotien_txt.getText());
            mapm = Integer.parseInt(mapm_txt1.getText());
            lydo = lydo_txt.getText();
            date = phieuPhat_BUS.FormatDateSQL(ngaytra_txt1.getText());
           
            checked = true;

            } catch (Exception e) {
                checked = false;
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
                    "Dữ liệu không đúng định dạng.");
            }
            if (checked){
                if (RowSelected == -1 && phieuphat == null) {

                    phieuphat = new PhieuPhat(mapp, mapm, date, sotien, lydo);

                    if (phieuPhat_BUS.ThemPhieuPhat(phieuphat)) {

                        table_PhieuPhat.addRow(new Object[] {mapp, mapm, phieuPhat_BUS.FormatDate(date),  lydo, sotien});
                    }

                phieuphat = null;

                }else {

                    PhieuPhat ppUpdate = new PhieuPhat(mapp, mapm, date, sotien, lydo);

                    if (phieuPhat_BUS.SuaPhieuPhat(ppUpdate,phieuphat)) {

                        table_PhieuPhat.updateRow(RowSelected, new Object[]{mapp, mapm, phieuPhat_BUS.FormatDate(date), lydo, sotien});
                    }       
                    phieuphat = ppUpdate;
                    ppUpdate = null;

                }
        }
    }//GEN-LAST:event_save_btn1ActionPerformed

    private void add_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btn1ActionPerformed
        setToDefault();
    }//GEN-LAST:event_add_btn1ActionPerformed

    private void delete_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btn1ActionPerformed
         if (RowSelected != -1) {
            ImageIcon icon = new FlatSVGIcon("IMG/icon/warning.svg",30,30);
            String[] cf = {"Đồng ý", "Hủy"};
            int choice = JOptionPane.showOptionDialog(null,"Xóa phiếu phạt \"" + phieuphat.getMaPP() +"\" ?","Xác Nhận",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, cf ,null);
            if (choice == 0) {

                if (phieuPhat_BUS.XoaPhieuPhat(phieuphat)) {
                    table_PhieuPhat.deleteRow(RowSelected);
                    setToDefault();

                }
            }
        }else{
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
                "Vui lòng chọn phiếu phạt.");
        }
    }//GEN-LAST:event_delete_btn1ActionPerformed

    private void back4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back4ActionPerformed
        
        card.first(this);
    }//GEN-LAST:event_back4ActionPerformed

    private void chooseDate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseDate2ActionPerformed
        DateChooser date = new DateChooser();
        date.setTextRefernce(ngaytra_txt1);
        date.showPopup(chooseDate2, - 186, -130);
    }//GEN-LAST:event_chooseDate2ActionPerformed

    private void mapp_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mapp_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mapp_txtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CTPM;
    private GUI.UIComponents.Combobox ChonTinhTrang;
    private javax.swing.JPanel PhieuMuon;
    private javax.swing.JPanel PhieuPhat;
    private GUI.UIComponents.Button add_btn;
    private GUI.UIComponents.Button add_btn1;
    private GUI.UIComponents.Button add_btn_PM;
    private GUI.UIComponents.Button back3;
    private GUI.UIComponents.Button back4;
    private GUI.UIComponents.Button chitiet_btn;
    private GUI.UIComponents.Button chooseDate;
    private GUI.UIComponents.Button chooseDate1;
    private GUI.UIComponents.Button chooseDate2;
    private GUI.UIComponents.Button delete_btn;
    private GUI.UIComponents.Button delete_btn1;
    private GUI.UIComponents.Button delete_btn_PM;
    private GUI.UIComponents.Button export_PN;
    private GUI.UIComponents.TextField ghichu_txt;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private GUI.UIComponents.TextField lydo_txt;
    private GUI.UIComponents.TextField maCTPM_txt;
    private GUI.UIComponents.TextField madocgia_txt;
    private GUI.UIComponents.TextField manhanvien_txt;
    private GUI.UIComponents.TextField maphieumuon_txt;
    private GUI.UIComponents.TextField mapm_txt;
    private GUI.UIComponents.TextField mapm_txt1;
    private GUI.UIComponents.TextField mapp_txt;
    private GUI.UIComponents.TextField masach_txt;
    private GUI.UIComponents.TextField ngaymuon_txt;
    private GUI.UIComponents.TextField ngayquahan_txt;
    private GUI.UIComponents.TextField ngaytra_txt;
    private GUI.UIComponents.TextField ngaytra_txt1;
    private GUI.UIComponents.Panel.PanelBorder panelBorder1;
    private GUI.UIComponents.Panel.PanelBorder panelBorder2;
    private GUI.UIComponents.Panel.PanelBorder panelBorder3;
    private GUI.UIComponents.Button phieuphat_btn;
    private GUI.UIComponents.Button save_btn;
    private GUI.UIComponents.Button save_btn1;
    private GUI.UIComponents.Button save_btn_PM;
    private GUI.UIComponents.TextField sotien_txt;
    private GUI.UIComponents.Table.Table table_CTPM;
    private GUI.UIComponents.Table.Table table_PM;
    private GUI.UIComponents.Table.Table table_PhieuPhat;
    private GUI.UIComponents.TextField tensach_txt;
    // End of variables declaration//GEN-END:variables


}


