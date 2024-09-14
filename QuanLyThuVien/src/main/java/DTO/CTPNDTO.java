/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author X
 */
public class CTPNDTO {
    private int maCTPN;
    private int maSach;
    private int soLuong;
    private double gia;

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
    
    
    
    public int getMaCTPN() {
        return maCTPN;
    }

    public void setMaCTPN(int maCTPN) {
        this.maCTPN = maCTPN;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public CTPNDTO(int maCTPN, int maSach,double gia,int soLuong) {
        this.maCTPN = maCTPN;
        this.maSach = maSach;
        this.gia = gia;
        this.soLuong = soLuong;
    }

    public CTPNDTO() {
    }

    @Override
    public String toString() {
        return "CTPNDTO{" + "maCTPN=" + maCTPN + ", maSach=" + maSach + ", soLuong=" + soLuong + ", gia=" + gia + '}';
    }
    
    
    
}
