/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap_04_TIVI;

import java.util.Scanner;

/**
 *
 * @author Manh Hai
 */
public class Program {
    public static void main(String[] args) {
        CTivi cTivi = null;
        int choose;
        Scanner input = new Scanner(System.in);
        
        showInitTivi();
        choose = Integer.parseInt(input.nextLine());
        if(choose == 1) {
            cTivi = new CTivi();
        } else if(choose == 2) {
            System.out.println("Nhap so luong kenh ban muon.");
            int n = Integer.parseInt(input.nextLine());
            String[] channelListInit = new String[n];
            for(int i = 0; i < n; i++) {
                System.out.println("Nhap kenh thu " + (i+1));
                channelListInit[i] = input.nextLine();
            }
            cTivi = new CTivi(channelListInit);
        }
         
        do {
           showMenu();
           choose = Integer.parseInt(input.nextLine());
           
           switch(choose) {
               case 1:
                   cTivi.Switch();
                   break;
               case 2:
                   System.out.println("Nhap kenh can chuyen: ");
                   String setChannel = input.nextLine();
                   cTivi.Switch(setChannel);
                   break;
               case 3:
                   cTivi.On();
                   break;
               case 4:
                   cTivi.Off();
                   break;
               case 5:
                   cTivi.nextChannel();
                   break;
               case 6:
                   cTivi.previousChannel();
                   break;
               case 7:
                   cTivi.showTivi();
                   break;
               case 8:
                   System.out.println("Chuong trinh ket thuc.");
                   break;
               default:
                   System.err.println("Chuong trinh khong tim thay chuc nang ban muon.");
                   break;
           }
        } while (choose != 8);
        
    }
    
    static void showMenu() {
        System.out.println("---Menu---");
        System.out.println("1. Chuyen trang thai (Switch).");
        System.out.println("2. Chuyen trang thai kem theo kenh.");
        System.out.println("3. Bat Tivi.");
        System.out.println("4. Tat Tivi.");
        System.out.println("5. Chuyen kenh tiep.");
        System.out.println("6. Chuyen kenh truoc.");
        System.out.println("7. Xem thong tin Tivi.");
        System.out.println("8. Ket thuc.");
        System.out.println("Choose: ");
    }
    
    static void showInitTivi() {
        System.out.println("---Lua chon cach khoi tao danh sach kenh---");
        System.out.println("1. Mac dinh");
        System.out.println("2. Tuy chon");
        System.out.println("Choose: ");
    }
}
