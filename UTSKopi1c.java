import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;


    public class UTSKopi1c {

        static String[] dont_be_late = new String[400];
        static String[] goncang_jiwa = new String[300];
        static String[] jalan_kenangan = new String[300];
        static String[] tanpa_rasa = new String[250];

        static int stok = dont_be_late.length + goncang_jiwa.length + jalan_kenangan.length + tanpa_rasa.length;
        static int sisa = stok;

        public static void main(String[] args) {
            System.out.println("Pesan Kopi");
            pesan();
        }

        static void print_data_pesanan() {
            //menambah total dengan mengecek setiap slot array jenis kopi yang terisi
            int total_dontbelate = 0;
            for (int i = 0; i < dont_be_late.length; i++) {
                if (dont_be_late[i] != null) {
                    total_dontbelate++;
                }
            }

            int total_goncangjiawa = 0;
            for (int i = 0; i < goncang_jiwa.length; i++) {
                if (goncang_jiwa[i] != null) {
                    total_goncangjiawa++;
                }
            }

            int total_jalankenangan = 0;
            for (int i = 0; i < jalan_kenangan.length; i++) {
                if (jalan_kenangan[i] != null) {
                    total_jalankenangan++;
                }
            }

            int total_tanparasa = 0;
            for (int i = 0; i < tanpa_rasa.length; i++) {
                if (tanpa_rasa[i] != null) {
                    total_tanparasa++;
                }
            }

            sisa = stok - total_dontbelate - total_goncangjiawa - total_jalankenangan - total_tanparasa;
            System.out.println("Data Penjualan Kopi");
            System.out.println("Don't Be Late :" + total_dontbelate + " Cup terjual  " + (dont_be_late.length-total_dontbelate) + " Cup tersisa");
            System.out.println("Goncang Jiwa :" + total_goncangjiawa + " Cup terjual " + (goncang_jiwa.length-total_goncangjiawa) + " Cup tersisa");
            System.out.println("Jalan Kenangan :" + total_jalankenangan + " Cup terjual  " + (jalan_kenangan.length-total_jalankenangan) + " Cup tersisa");
            System.out.println("Kopi Pahit Tanpa Rasa :" + total_tanparasa + " Cup terjual " + (tanpa_rasa.length-total_tanparasa) + " Cup tersisa" );

            ArrayList<Integer> penjualan = new ArrayList<Integer>();
            penjualan.add(total_dontbelate);
            penjualan.add(total_goncangjiawa);
            penjualan.add(total_jalankenangan);
            penjualan.add(total_tanparasa);

            Collections.sort(penjualan, Collections.reverseOrder());

            System.out.println("Kopi paling banyak disukai" );

            if (total_dontbelate == penjualan.get(0)) {
                System.out.println("- Don't Be Late");
            }

            if (total_goncangjiawa == penjualan.get(0)) {
                System.out.println("- Goncang Jiwa");
            }

            if (total_jalankenangan == penjualan.get(0)) {
                System.out.println("- Jalan Kenangan");
            }

            if (total_tanparasa == penjualan.get(0)) {
                System.out.println("- Pahit Tanpa Rasa");
            }

            System.out.println("Kopi paling tidak disukai");

            if (total_dontbelate == penjualan.get(3)) {
                System.out.println("- Don't Be Late");
            }

            if (total_goncangjiawa == penjualan.get(3)) {
                System.out.println("- Goncang Jiwa");
            }

            if (total_jalankenangan == penjualan.get(3)) {
                System.out.println("- Jalan Kenangan");
            }

            if (total_tanparasa == penjualan.get(3)) {
                System.out.println("- Pahit Tanpa Rasa");
            }

            System.out.println("Total kopi terjual : " + (total_dontbelate + total_goncangjiawa + total_jalankenangan + total_tanparasa) + " Cup");
            System.out.println("Total sisa kopi : " + sisa + " Cup");

        }

        static void cek_data_pesanan(String[] jenis, String pembeli) {
            for (int i = 0; i < jenis.length; i++) {

                if (jenis[i] == null) {
                    jenis[i] = pembeli;
                    break;
                }
            }
        }

        static void data_pesanan(int jenis, String nama){
            System.out.print(nama + " memesan Kopi ");

            switch (jenis) {
                case 1:
                    cek_data_pesanan(dont_be_late, nama);
                    System.out.println("Don't Be Late");
                    break;
                case 2:
                    cek_data_pesanan(goncang_jiwa, nama);
                    System.out.println("Goncang jiwa");
                    break;
                case 3:
                    cek_data_pesanan(jalan_kenangan, nama);
                    System.out.println("Jalan Kenangan");
                    break;
                case 4:
                    cek_data_pesanan(tanpa_rasa, nama);
                    System.out.println("Pahit Tanpa Rasa");
                    break;
            }

            print_data_pesanan();
        }

        static void pesan() {
            try (Scanner pembeli = new Scanner(System.in)) {
                while (true) {
                    System.out.print("nnama pembeli : ");
                    String nama_pemebeli =  pembeli.nextLine();

                    if (nama_pemebeli.isBlank()) {
                        System.out.println("nama pembeli wajib diisi");
                        pesan();
                    }else if (sisa == 0) {
                        System.out.println("Maaf semua kopi sudah habis");
                        pesan();
                    }else{
                        Random gacha = new Random();
                        int jenisrandom = gacha.nextInt(4) + 1;
                        data_pesanan(jenisrandom, nama_pemebeli);
                    }
                }
            }
        }
    }

