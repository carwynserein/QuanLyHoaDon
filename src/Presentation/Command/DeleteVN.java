package Presentation.Command;

import javax.swing.JOptionPane;

import Domain.HoaDonTienDienChucNang;
import Domain.Model.HoaDonTienDienNN;
import Domain.Model.HoaDonTienDienVN;
import Presentation.HoaDonTienDienController;
import Presentation.HoaDonTienDienView;

public class DeleteVN extends Command {

   public DeleteVN(HoaDonTienDienNN hoaDonTienDienNN,
            HoaDonTienDienVN hoaDonTienDienVN, HoaDonTienDienChucNang hoaDonTienDienChucNang,
            HoaDonTienDienView hoaDonTienDienView, HoaDonTienDienController hoaDonTienDienController) {
        super(hoaDonTienDienNN, hoaDonTienDienVN, hoaDonTienDienChucNang, hoaDonTienDienView,
                hoaDonTienDienController);
        this.hoaDonTienDienChucNang = hoaDonTienDienChucNang;
    }

    @Override
    public void execute() {
        hoaDonTienDienVN.setIdKh(Integer.parseInt(hoaDonTienDienView.getIdTextField().getText()));
        delete(hoaDonTienDienChucNang);
        JOptionPane.showMessageDialog(hoaDonTienDienView, "Xóa thành công");
    }

    public void delete(HoaDonTienDienChucNang hoaDonTienDiencChucNang) {
        hoaDonTienDiencChucNang.deleteHoaDonVN(hoaDonTienDienVN);
    }
}
