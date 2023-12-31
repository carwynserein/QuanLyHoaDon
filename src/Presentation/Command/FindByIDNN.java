package Presentation.Command;

import java.util.List;
import java.util.Objects;

import javax.swing.JOptionPane;

import Domain.HoaDonTienDienChucNang;
import Domain.Model.HoaDonTienDienNN;
import Domain.Model.HoaDonTienDienVN;
import Presentation.HoaDonTienDienController;
import Presentation.HoaDonTienDienView;

public class FindByIDNN extends Command {

    public FindByIDNN(HoaDonTienDienNN hoaDonTienDienNN, HoaDonTienDienVN hoaDonTienDienVN,
            HoaDonTienDienChucNang hoaDonTienDienChucNang,
            HoaDonTienDienView hoaDonTienDienView, HoaDonTienDienController hoaDonTienDienController) {
        super(hoaDonTienDienNN, hoaDonTienDienVN, hoaDonTienDienChucNang, hoaDonTienDienView,
                hoaDonTienDienController);
    }

    @Override
    public void execute() {
        findByID();
    }

    public void findByID() {
        String ten = JOptionPane.showInputDialog(hoaDonTienDienView, "Nhập Tên", "Tên", JOptionPane.PLAIN_MESSAGE);

        if (ten != null && !ten.isEmpty()) {
            boolean found = false; //
            List<HoaDonTienDienNN> hoaDonNNList = hoaDonTienDienChucNang.getAllHoaDonTienDienNN();
            hoaDonTienDienView.getTableModelNN().setRowCount(0); // Xóa toàn bộ dữ liệu trong bảng HoaDonTienDienVN

            // Tìm kiếm và thêm chỉ hàng ID cần tìm vào bảng HoaDonTienDienVN
            for (HoaDonTienDienNN hoaDonNN : hoaDonNNList) {
                if (hoaDonNN != null && Objects.equals(hoaDonNN.getHoTen().toLowerCase(), ten.toLowerCase())) {
                    Object[] rowData = {
                            hoaDonNN.getIdKh(),
                            hoaDonNN.getHoTen(),
                            hoaDonNN.getQuocTich(),
                            hoaDonNN.getNgayHD() != null ? hoaDonNN.getNgayHD().toString() : "",
                            hoaDonNN.getSoLuong(),
                            hoaDonNN.getDonGia(),
                            hoaDonNN.thanhTien()
                    };
                    hoaDonTienDienView.getTableModelNN().addRow(rowData); // Thêm hàng cần tìm vào bảng
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
