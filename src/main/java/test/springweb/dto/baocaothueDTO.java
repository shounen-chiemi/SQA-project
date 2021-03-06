package test.springweb.dto;

import test.springweb.entity2.chitietthuesuat;
import test.springweb.entity2.khoangiamtru;
import test.springweb.entity2.nguoidongthue;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class baocaothueDTO {
    private int id;
    private String loaithue;
    private float tnct;
    private Date ngaynop;
    private String tinhtrang;
    private int songuoiphuthuoc;
    private chitietthuesuat chitietthuesuat;
    private int tongtien;
    private nguoidongthue nguoidongthue;
    private List<khoangiamtru> list_khoangiamtru = new ArrayList<>();

    public baocaothueDTO(int id, String loaithue, float tnct, Date ngaynop, String tinhtrang, int songuoiphuthuoc, test.springweb.entity2.chitietthuesuat chitietthuesuat, int tongtien, test.springweb.entity2.nguoidongthue nguoidongthue, List<khoangiamtru> list_khoangiamtru) {
        this.id = id;
        this.loaithue = loaithue;
        this.tnct = tnct;
        this.ngaynop = ngaynop;
        this.tinhtrang = tinhtrang;
        this.songuoiphuthuoc = songuoiphuthuoc;
        this.chitietthuesuat = chitietthuesuat;
        this.tongtien = tongtien;
        this.nguoidongthue = nguoidongthue;
        this.list_khoangiamtru = list_khoangiamtru;
    }
    public baocaothueDTO()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoaithue() {
        return loaithue;
    }

    public void setLoaithue(String loaithue) {
        this.loaithue = loaithue;
    }

    public float getTnct() {
        return tnct;
    }

    public void setTnct(float tnct) {
        this.tnct = tnct;
    }

    public Date getNgaynop() {
        return ngaynop;
    }

    public void setNgaynop(Date ngaynop) {
        this.ngaynop = ngaynop;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public int getSonguoiphuthuoc() {
        return songuoiphuthuoc;
    }

    public void setSonguoiphuthuoc(int songuoiphuthuoc) {
        this.songuoiphuthuoc = songuoiphuthuoc;
    }

    public test.springweb.entity2.chitietthuesuat getChitietthuesuat() {
        return chitietthuesuat;
    }

    public void setChitietthuesuat(test.springweb.entity2.chitietthuesuat chitietthuesuat) {
        this.chitietthuesuat = chitietthuesuat;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public test.springweb.entity2.nguoidongthue getNguoidongthue() {
        return nguoidongthue;
    }

    public void setNguoidongthue(test.springweb.entity2.nguoidongthue nguoidongthue) {
        this.nguoidongthue = nguoidongthue;
    }

    public List<khoangiamtru> getList_khoangiamtru() {
        return list_khoangiamtru;
    }

    public void setList_khoangiamtru(List<khoangiamtru> list_khoangiamtru) {
        this.list_khoangiamtru = list_khoangiamtru;
    }
}
