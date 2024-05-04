
package GUI.UIComponents;

import BUS.ChiTietPhieuMuon_BUS;
import BUS.PhieuMuon_BUS;
import DTO.ChiTietPhieuMuon;
import DTO.PhieuMuon;
import GUI.UIComponents.DATE.DateChooser;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.CardLayout;
import java.awt.Color;
import java.time.LocalDate;
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
    private static PhieuMuon phieumuon;
    private PhieuMuon_BUS phieuMuon_BUS;
    private static ChiTietPhieuMuon ctpm;
    private static ChiTietPhieuMuon_BUS chiTietPhieuMuon_BUS;
    
    public Form_MuonSach() {
        initComponents();
        
        phieuMuon_BUS = new PhieuMuon_BUS();
        chiTietPhieuMuon_BUS = new ChiTietPhieuMuon_BUS();
        
        card = (CardLayout) this.getLayout();
        card.show(Form_MuonSach.this, "PhieuMuon");
        
        ChonTinhTrang.setSelectedIndex(-1);
        
        phieuMuon_BUS.RenderPhieuMuon(table_PM);
        table_PM.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
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
                         
                    }
                    
                }

            });
   
    
    
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
        jScrollPane3 = new javax.swing.JScrollPane();
        table_CTPM = new GUI.UIComponents.Table.Table();
        PhieuPhat = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_PhieuPhat = new GUI.UIComponents.Table.Table();
        panelBorder2 = new GUI.UIComponents.Panel.PanelBorder();

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
        panelBorder1.add(maphieumuon_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 240, 50));

        ChonTinhTrang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ĐÃ TRẢ", "QUÁ HẠN", "ĐANG MƯỢN" }));
        ChonTinhTrang.setSelectedIndex(-1);
        ChonTinhTrang.setLabeText("Tình trạng");
        panelBorder1.add(ChonTinhTrang, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 90, 240, 40));

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

        table_CTPM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Chi Tiết Phiếu Mượn", "Mã Phiếu Mượn", "Mã Sách", "Ngày Trả", "Ghi Chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false
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
                .addComponent(panelBorder3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(CTPM, "card3");

        PhieuPhat.setBackground(new Color(0,0,0,0));

        table_PhieuPhat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Phiếu Phạt", "Mã Phiếu Mượn", "Ngày Trả", "Lý Do", "Số Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_PhieuPhat.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jScrollPane2.setViewportView(table_PhieuPhat);

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 222, Short.MAX_VALUE)
        );

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
                .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(PhieuPhat, "card4");
    }// </editor-fold>//GEN-END:initComponents

    private void chitiet_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chitiet_btnActionPerformed

//        if (RowSelected != -1 && phieumuon != null) {
//            try {
//
//                int mapm = phieumuon.getMaPhieuMuon();
//                RowSelected = table_CTPM.find(mapm, 1);
//
//                if (RowSelected != -1) {
//                    table_CTPM.setRowSelectionInterval(RowSelected, RowSelected);
//
//                    ctpm = chiTietPhieuMuon_BUS.SelectedCTPM(Integer.parseInt(table_CTPM.getModel().
//                        getValueAt(RowSelected, 0).toString()));
//
//                .setText(Integer.toString(ctpn.getMaCTPN()));
//
//                maphieunhap_CT_txt.setText(Integer.toString(ctpn.getMaPhieuNhap()));
//                masach_txt.setText(Integer.toString(ctpn.getMaSach()));
//                tensach_txt.setText(sach_BUS.getTenSach(ctpn.getMaSach()));
//                tensach_txt.setEnabled(false);
//
//                gia_txt.setText(Integer.toString(ctpn.getGia()));
//                soluong_txt.setText(Integer.toString(ctpn.getSoLuong()));
//
//                card.next(this);
//            }
//
//        } catch (NullPointerException e) {
//            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
//                "Chi tiết phiếu nhập không tồn tại.");
//
//        } catch (IllegalArgumentException e){
//            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
//                "Chi tiết phiếu nhập không tồn tại.");
//        }
//
//        }else {
//            card.next(this);
//        }

    }//GEN-LAST:event_chitiet_btnActionPerformed

    private void phieuphat_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phieuphat_btnActionPerformed
        card.last(this);

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
                    Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT,
                        "Xóa phiếu mượn thành công.");
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

        int soluong = -1;
        int masach = -1;
        int maloaisach = -1;
        int manxb = -1;
        int matacgia = -1;
        String tensach = "";
        LocalDate date = LocalDate.now();
        String ghichu = "";
        String hinhanh = "";

//        try {
//
//            soluong = Integer.parseInt(soluong_txt.getText());
//            masach = Integer.parseInt(masach_txt.getText());
//            maloaisach = loaiSach_BUS.getMaloaiSach(ChonTheLoai.getSelectedItem().toString());
//            manxb = nhaXuatBan_BUS.getManhaxuatban(ChonNXB.getSelectedItem().toString());
//            matacgia = tacGia_BUS.getMatacgia(ChonTG.getSelectedItem().toString());
//            tensach = tensach_txt.getText();
//            date = sach_BUS.FormatDateSQL(namxuatban_txt.getText());
//            ghichu = "";
//            if (isChoosed) {
//                String path = ch.getSelectedFile().toString();
//                hinhanh = path.substring(path.lastIndexOf("\\"  ) + 1);
//                    isChoosed = false;
//                }else {
//                    if (sach == null) {
//                        hinhanh = "default.svg";
//                    }else{
//                        hinhanh = sach.getImgSach();
//                    }
//                }
//
//                checked = true;
//
//            } catch (Exception e) {
//                checked = false;
//                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
//                    "Dữ liệu không đúng định dạng.");
//            }
//            if (checked){
//                if (RowSelected == -1 && sach == null) {
//
//                    sach = new Sach(masach, tensach, hinhanh, maloaisach, manxb, matacgia, date, soluong, ghichu);
//
//                    if (sach_BUS.ThemSach(sach)) {
//
//                        Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT,
//                            "Thêm sách thành công.");
//                        table_Sach.addRow(new Object[] {masach, tensach, ChonNXB.getSelectedItem().toString(),
//                            namxuatban_txt.getText(), ChonTG.getSelectedItem().toString(), soluong});
//
//                }else {
//                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
//                        "Sách đã tồn tại.");
//                }
//
//                sach = null;
//
//            }else {
//
//                Sach sachUpdate = new Sach(masach, tensach, hinhanh, maloaisach, manxb, matacgia, date, soluong, ghichu);
//
//                if (sach_BUS.SuaSach(sachUpdate,sach)) {
//
//                    table_Sach.updateRow(RowSelected, new Object[]{masach, tensach, ChonNXB.getSelectedItem().toString(),
//                        namxuatban_txt.getText(), ChonTG.getSelectedItem().toString(), soluong});
//                if (hinhanh.equals("default.svg")) {
//                    IMG.setIcon(defaultIMG);
//                }else{
//                    IMG.setIcon(new HighRE().setIconJPG(sachUpdate.getImgSach(), "Sach"));
//                }
//                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT,
//                    "Lưu thành công.");
//                sach = sachUpdate;
//                sachUpdate = null;
//            }else {
//                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
//                    "Lưu không thành công.");
//            }
//
//        }
//        }
//
    }//GEN-LAST:event_save_btnActionPerformed

    private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btnActionPerformed

        //remove data selected
        setToDefault();

    }//GEN-LAST:event_add_btnActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
//        //        Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, "Hello");
//        if (RowSelected != -1) {
//            ImageIcon icon = new FlatSVGIcon("IMG/icon/warning.svg",30,30);
//            String[] cf = {"Đồng ý", "Hủy"};
//            int choice = JOptionPane.showOptionDialog(null,"Xóa sách \"" + sach.getTenSach()+"\" ?","Xác Nhận",
//                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, cf ,null);
//            if (choice == 0) {
//
//                if (sach_BUS.XoaSach(sach)) {
//                    table_Sach.deleteRow(RowSelected);
//                    Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT,
//                        "Xóa sách thành công.");
//                    setToDefault();
//
//                }
//            }
//        }else{
//            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT,
//                "Vui lòng chọn sách.");
//        }
//
    }//GEN-LAST:event_delete_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CTPM;
    private GUI.UIComponents.Combobox ChonTinhTrang;
    private javax.swing.JPanel PhieuMuon;
    private javax.swing.JPanel PhieuPhat;
    private GUI.UIComponents.Button add_btn;
    private GUI.UIComponents.Button add_btn_PM;
    private GUI.UIComponents.Button chitiet_btn;
    private GUI.UIComponents.Button chooseDate;
    private GUI.UIComponents.Button delete_btn;
    private GUI.UIComponents.Button delete_btn_PM;
    private GUI.UIComponents.Button export_PN;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private GUI.UIComponents.TextField madocgia_txt;
    private GUI.UIComponents.TextField manhanvien_txt;
    private GUI.UIComponents.TextField maphieumuon_txt;
    private GUI.UIComponents.TextField ngaymuon_txt;
    private GUI.UIComponents.Panel.PanelBorder panelBorder1;
    private GUI.UIComponents.Panel.PanelBorder panelBorder2;
    private GUI.UIComponents.Panel.PanelBorder panelBorder3;
    private GUI.UIComponents.Button phieuphat_btn;
    private GUI.UIComponents.Button save_btn;
    private GUI.UIComponents.Button save_btn_PM;
    private GUI.UIComponents.Table.Table table_CTPM;
    private GUI.UIComponents.Table.Table table_PM;
    private GUI.UIComponents.Table.Table table_PhieuPhat;
    // End of variables declaration//GEN-END:variables


}


