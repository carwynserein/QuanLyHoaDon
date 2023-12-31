package Presentation.Command;

import java.util.List;
import java.util.Objects;

import javax.swing.JOptionPane;

import Domain.HoaDonTienDienChucNang;
import Domain.Model.HoaDonTienDienNN;
import Domain.Model.HoaDonTienDienVN;
import Presentation.HoaDonTienDienController;
import Presentation.HoaDonTienDienView;

public class FindByIDVN extends Command {

    public FindByIDVN(HoaDonTienDienNN hoaDonTienDienNN,
            HoaDonTienDienVN hoaDonTienDienVN, HoaDonTienDienChucNang hoaDonTienDienChucNang,
            HoaDonTienDienView hoaDonTienDienView, HoaDonTienDienController hoaDonTienDienController) {
        super(hoaDonTienDienNN, hoaDonTienDienVN, hoaDonTienDienChucNang, hoaDonTienDienView,
                hoaDonTienDienController);
        this.hoaDonTienDienChucNang = hoaDonTienDienChucNang;
    }

    @Override
    public void execute() {
        findByID();
    }

    public void findByID() {
        String ten = JOptionPane.showInputDialog(hoaDonTienDienView, "Nhập Tên", "Tên", JOptionPane.PLAIN_MESSAGE);

        if (ten != null && !ten.isEmpty()) {
            boolean found = false; //
            List<HoaDonTienDienVN> hoaDonVNList = hoaDonTienDienChucNang.getAllHoaDonTienDienVN();
            hoaDonTienDienView.getTableModelVN().setRowCount(0); // Xóa toàn bộ dữ liệu trong bảng HoaDonTienDienVN
            // Tìm kiếm và thêm chỉ hàng ID cần tìm vào bảng HoaDonTienDienVN
            for (HoaDonTienDienVN hoaDonVN : hoaDonVNList) {
                if (hoaDonVN != null && Objects.equals(hoaDonVN.getHoTen().toLowerCase(),ten.toLowerCase())) {
                    Object[] rowData = {
                            hoaDonVN.getIdKh(),
                            hoaDonVN.getHoTen(),
                            hoaDonVN.getNgayHD() != null ? hoaDonVN.getNgayHD().toString() : "",
                            hoaDonVN.getSoLuong(),
                            hoaDonVN.fromvalue(hoaDonVN.getDoiTuong()),
                            hoaDonVN.getDonGia(),
                            hoaDonVN.getDinhMuc(),
                            hoaDonVN.thanhTien()
                    };
                    hoaDonTienDienView.getTableModelVN().addRow(rowData); // Thêm hàng cần tìm vào bảng
                    found = true; // Đã tìm thấy ID
                }
            }
            if (!found) {
                JOptionPane.showMessageDialog(hoaDonTienDienView, "Không tìm thấy hóa đơn cần tìm!", "Thông báo",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
