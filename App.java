import java.lang.invoke.StringConcatException;
import java.text.StringCharacterIterator;
import java.util.Scanner;

import javax.swing.text.StringContent;
 class formatBiodata
{ //bagian deklarasi struktur record ----------------------------------
String nama;
String alamat;
int umur;
char jekel;
String hobi[]=new String[3];
float ipk;

}

class pertemuan3
{ public static int N;

//--------------------------------------------------
//--- Fungsi untuk mengentri data ke dalam Larik ---
//--------------------------------------------------
public static void ngentriData(formatBiodata biodataMahasiswa[])
{
//bagian entri data ke dalam struktur larik ----------------
Scanner masukan = new Scanner(System.in);

int bacaTombol=0;
for (int i=0; i<=N-1; i++){ 
    System.out.println("---------------input data----------------");
System.out.print("Silakan masukkan nama anda : ");
biodataMahasiswa[i].nama = masukan.next();
System.out.print("Silakan masukkan alamat anda : ");
biodataMahasiswa[i].alamat = masukan.next();
System.out.print("Silakan masukkan umur anda : ");
biodataMahasiswa[i].umur = masukan.nextInt();
System.out.print("Silakan masukkan Jenis Kelamin anda : ");
try
{ bacaTombol = System.in.read();
}
catch(java.io.IOException e)
{
}
biodataMahasiswa[i].jekel = (char)bacaTombol;
System.out.println("Silakan masukkan hobi (maks 3) : ");
System.out.print("hobi ke-0 : ");
biodataMahasiswa[i].hobi[0] = masukan.next();
System.out.print("hobi ke-1 : ");
biodataMahasiswa[i].hobi[1] = masukan.next();
System.out.print("hobi ke-2 : ");
biodataMahasiswa[i].hobi[2] = masukan.next();
System.out.print("Silakan masukkan IPK anda : ");
biodataMahasiswa[i].ipk = masukan.nextFloat();
System.out.println("");

}
}

//============================================================================

//--------------------------------------------------
//--- Fungsi untuk Menambah Data Di Depan ---
//--------------------------------------------------
public static void tambahData(formatBiodata biodataMahasiswa[])
{
//bagian membuat record sementara untuk menampung data baru-------------
formatBiodata biodataMahasiswaBaru = new formatBiodata();
//bagian entri data baru ke penyimpan sementara-----------------------
Scanner masukan = new Scanner(System.in);
int bacaTombol=0;
System.out.println("---------------tambah data----------------");
System.out.print("Silakan masukkan nama anda : ");
biodataMahasiswaBaru.nama = masukan.next();
System.out.print("Silakan masukkan alamat anda : ");
biodataMahasiswaBaru.alamat = masukan.next();
System.out.print("Silakan masukkan umur anda : ");
biodataMahasiswaBaru.umur = masukan.nextInt();
System.out.print("Silakan masukkan Jenis Kelamin anda : ");
try
{ bacaTombol = System.in.read();
}
catch(java.io.IOException e)
{
}
biodataMahasiswaBaru.jekel = (char)bacaTombol;
System.out.println("Silakan masukkan hobi (maks 3) : ");
System.out.print("hobi ke-0 : ");
biodataMahasiswaBaru.hobi[0] = masukan.next();
System.out.print("hobi ke-1 : ");
biodataMahasiswaBaru.hobi[1] = masukan.next();
System.out.print("hobi ke-2 : ");
biodataMahasiswaBaru.hobi[2] = masukan.next();
System.out.print("Silakan masukkan IPK anda : ");
biodataMahasiswaBaru.ipk = masukan.nextFloat();
System.out.println("");

int A=0;
System.out.println("silahkan pilih salah satu:");
System.out.println("[1] letakan data di depan");
System.out.println("[2] letakan data di tengah");
System.out.println("[3] letakan data di belakang");
System.out.print("pilih : ");
A = masukan.nextInt();
switch(A){
    case 1: //menambahkan data di depan
        //bagian menggeser isi larik mulai dari Belakang s/d 0 selangkah ke bawah
        for (int i=N-1; i>= 0; i--)
        { biodataMahasiswa[i+1] = biodataMahasiswa[i];
        }
        //bagian memindahkan data baru ke larik ke-0-----------------------
        biodataMahasiswa[0] = biodataMahasiswaBaru;
        //memperbaharui banyaknya data (N), banyaknya data bertambah satu------
        N++;
        tampilkanData(biodataMahasiswa);
        break;
    case 2: //menambahkan data di tengah
        //bagian menentukan posisi target T ----------------------------------
        int T;
        System.out.println("jumlah data : "+biodataMahasiswa.length);
        System.out.print("Pada posisi ke berapa data akan dimasukkan ? : ");
        T = masukan.nextInt();
        //bagian menggeser isi larik mulai dari Belakang s/d T selangkah ke belakang
        for (int i=N-1; i>= T; i--)
        { biodataMahasiswa[i+1] = biodataMahasiswa[i];
        }
        //bagian memindahkan data baru ke larik ke-T----------------------
        biodataMahasiswa[T-1] = biodataMahasiswaBaru;
        //memperbaharui banyaknya data (N), banyaknya data bertambah satu-------
        N++;
        tampilkanData(biodataMahasiswa);
        break;
    case 3: // menambahkan data di belakang
        //bagian memindahkan data baru ke larik ke-N-----------------------
        biodataMahasiswa[N] = biodataMahasiswaBaru;
        //memperbaharui banyaknya data (N), banyaknya data bertambah satu----
        N++;
        tampilkanData(biodataMahasiswa);
        break;
    default:
        System.out.println("input yang anda masukkan salah!");
        return;
}
}

//--------------------------------------------------
//--- Fungsi untuk Menghapus Data Di Depan ---
//--------------------------------------------------
public static void hapusDataDiDepan(formatBiodata biodataMahasiswa[])
{
//bagian menggeser isi larik mulai dari 0 - Belakang selangkah ke depan
for (int i=0; i<= N-2; i++)
{ biodataMahasiswa[i] = biodataMahasiswa[i+1];
}
System.out.println("Proses menghapus data ke-0 selesai.");
//memperbaharui banyaknya data (N), banyaknya data berkurang satu-------
N--;
tampilkanData(biodataMahasiswa);
}
//--------------------------------------------------
//--- Fungsi untuk Menghapus Data Di Tengah ---
//--------------------------------------------------
public static void hapusDataDiTengah(formatBiodata biodataMahasiswa[])
{
//bagian menentukan posisi target T --------------------------------------
Scanner masukan = new Scanner(System.in);
int T;
System.out.print("Tuliskan posisi data yang akan dibapus : ");
T = masukan.nextInt();
//bagian menggeser isi larik mulai dari T - Belakang selangkah ke depan
for (int i=T; i<= N-2; i++)
{ biodataMahasiswa[i] = biodataMahasiswa[i+1];
}
System.out.println("Proses menghapus data ke-" + T + " selesai.");
//memperbaharui banyaknya data (N), banyaknya data berkurang satu-------
N--;
tampilkanData(biodataMahasiswa);
}
//--------------------------------------------------
//--- Fungsi untuk Menghapus Data Di Belakang ---
//--------------------------------------------------
public static void hapusDataDiBelakang(formatBiodata biodataMahasiswa[])
{
System.out.println("Proses menghapus data paling akhir selesai.");
//memperbaharui banyaknya data (N), banyaknya data berkurang satu-------
N--;
tampilkanData(biodataMahasiswa);
}


//--------------------------------------------------------------------
//--- Fungsi untuk Mencari Data Secara Linear Search (Loop: While)---
//--------------------------------------------------------------------
public static void cariDataLinear (formatBiodata biodataMahasiswa[]){
Scanner masukan = new Scanner(System.in);
//bagian memasukkan kata kunci ------------------------------------------
    System.out.print("Silakan masukkan kataKunci data yang anda cari :");
    String kataKunci = masukan.next();
    boolean statusKetemu = false;
    int lokasiKetemu = -1;
//bagian mencari data satu persatu urut dari larik terdepan
    int i = 0;
        while ((i<=N-1) && (statusKetemu==false)){
//mencocokkan biodataMahasiswa[i].nama == kataKunci
            if (kataKunci.equals(biodataMahasiswa[i].nama)){
                statusKetemu = true;
                lokasiKetemu = i;
                }
                i++;
            }
    if (statusKetemu == true){ 
            System.out.println("Status Ketemu: "+statusKetemu+" di posisi ke " +lokasiKetemu);
            System.out.println("------------------------------------------------------------------------");
            System.out.println("NAMA \t ALAMAT \t UMUR \t JEKEL \t HOBI1 \t HOBI2 \t HOBI3 \t \t IPK");
            System.out.println("------------------------------------------------------------------------");
            System.out.print (biodataMahasiswa[lokasiKetemu].nama + " \t");
            System.out.print (biodataMahasiswa[lokasiKetemu].alamat + " \t \t");
            System.out.print (biodataMahasiswa[lokasiKetemu].umur + " \t");
            System.out.print (biodataMahasiswa[lokasiKetemu].jekel + " \t");
            System.out.print (biodataMahasiswa[lokasiKetemu].hobi[0] + " \t");
            System.out.print (biodataMahasiswa[lokasiKetemu].hobi[1] + " \t");
            System.out.print (biodataMahasiswa[lokasiKetemu].hobi[2] + " \t");
            System.out.println(biodataMahasiswa[lokasiKetemu].ipk);
    }
    else{
         System.out.println("maaf, nama yang anda cari tidak ditemukan");
    }
}
//------------------------------------------------------------------
//--- Fungsi untuk Mencari Data Secara Linear Search (Loop: For) ---
//------------------------------------------------------------------
public static void mencariDataLinear(formatBiodata biodataMahasiswa[]){ 
    String kataKunci;
    int lokasi=-1;
    boolean statusKetemu=false;
//bagian memasukkan kata kunci ------------------------------------------
    Scanner masukan = new Scanner(System.in);
    System.out.print("Masukkan kata kunci pencarian : ");
    kataKunci = masukan.next();
//bagian mencari data satu persatu urut dari larik terdepan
        for (int i=0; i<= N-1; i++){
//mencocokkan biodataMahasiswa[i].nama == kataKunci
            if (biodataMahasiswa[i].nama.equals(kataKunci)){ 
                statusKetemu = true;
                lokasi = i;
                break;
                }
            }
        
            
        if (statusKetemu == true){ 
            System.out.println("Data yang anda cari KETEMU di larik ke :"+ lokasi);
            System.out.println("------------------------------------------------------------------------");
            System.out.println("NAMA \t ALAMAT \t UMUR \t JEKEL \t HOBI1 \t HOBI2 \t HOBI3 \t \t IPK");
            System.out.println("------------------------------------------------------------------------");
            System.out.print (biodataMahasiswa[lokasi].nama + " \t");
            System.out.print (biodataMahasiswa[lokasi].alamat + " \t \t");
            System.out.print (biodataMahasiswa[lokasi].umur + " \t");
            System.out.print (biodataMahasiswa[lokasi].jekel + " \t");
            System.out.print (biodataMahasiswa[lokasi].hobi[0] + " \t");
            System.out.print (biodataMahasiswa[lokasi].hobi[1] + " \t");
            System.out.print (biodataMahasiswa[lokasi].hobi[2] + " \t");
            System.out.println(biodataMahasiswa[lokasi].ipk);
        }
        else{ 
            System.out.println("maap, nama yang anda cari tidak ditemukan");
        }
    }
//------------------------------------------------------
//--- Fungsi untuk Mencari Data Secara Binary Search ---
//------------------------------------------------------
public static void mencariDataBiner(formatBiodata biodataMahasiswa[]){ 
    String kataKunci;
    int lokasi=-1;
    boolean statusKetemu=false;
//bagian memasukkan kata kunci ------------------------------------------
    Scanner masukan = new Scanner(System.in);
    System.out.print("Masukkan kata kunci pencarian : ");
    kataKunci = masukan.next();
//bagian mencari data satu persatu urut dari larik terdepan
    int atas,bawah,tengah;
    atas = 0;
    bawah = N-1;
    tengah = (atas + bawah) / 2;
        while ((statusKetemu == false) && (bawah-atas!=1)){ 
            System.out.println(biodataMahasiswa[tengah].nama+" <---> "+kataKunci );
//jika kataKunci < biodataMahasiswa[tengah].nama)
                if (kataKunci.compareTo(biodataMahasiswa[tengah].nama) < 0){ 
                    bawah = tengah;
                    tengah = (atas + bawah) / 2;
                }
//jika kataKunci > biodataMahasiswa[tengah].nama)
                else if (kataKunci.compareTo(biodataMahasiswa[tengah].nama) > 0){ 
                    atas = tengah;
                    tengah = (atas + bawah) / 2;
                }
                else{ 
                    statusKetemu = true;
                    lokasi = tengah;
                }
            }
            if (statusKetemu == true){ 
                System.out.println("Data yang anda cari KETEMU di larik ke :"+ lokasi);
                System.out.println("------------------------------------------------------------------------");
                System.out.println("NAMA \t ALAMAT \t UMUR \t JEKEL \t HOBI1 \t HOBI2 \t HOBI3 \t \t IPK");
                System.out.println("------------------------------------------------------------------------");
                System.out.print (biodataMahasiswa[lokasi].nama + " \t");
                System.out.print (biodataMahasiswa[lokasi].alamat + " \t \t");
                System.out.print (biodataMahasiswa[lokasi].umur + " \t");
                System.out.print (biodataMahasiswa[lokasi].jekel + " \t");
                System.out.print (biodataMahasiswa[lokasi].hobi[0] + " \t");
                System.out.print (biodataMahasiswa[lokasi].hobi[1] + " \t");
                System.out.print (biodataMahasiswa[lokasi].hobi[2] + " \t");
                System.out.println(biodataMahasiswa[lokasi].ipk);


            }
            else{ 
                System.out.println("maap, nama yang anda cari tidak ditemukan ");
            }
        }

//------------------------------------------------------------------
//--- Fungsi untuk Mencari Data dengan syarat tertentu(Linear) Search (Loop: For) ---
//------------------------------------------------------------------
public static void mencariDataBersyarat(formatBiodata biodataMahasiswa[]){ 
    //formatBiodata MenampungBiodataMahasiswa = new formatBiodata();
    //int bacaTombol=0;
    String kataKunci;
    int lokasi=-1;
    boolean statusKetemu=false;
    
    //String konvert= String.valueOf(kataKunci);
//bagian memasukkan kata kunci ------------------------------------------
    Scanner masukan = new Scanner(System.in);
    //System.out.println("Hanya Tampilkan data : ");
    //System.out.println("[1] jenis kelamin Laki-laki");
    //System.out.println("[2] jenis kelamin Perempuan: ");
    System.out.println("----sortir menurut jenis kelamin---");
    System.out.print("masukkan (L/P) : ");
    kataKunci = masukan.next();
    char konvert=kataKunci.charAt(0);
//bagian mencari data satu persatu urut dari larik terdepan
        for (int i=0; i<= N-1; i++){
//mencocokkan biodataMahasiswa[i].jekel == kataKunci
            if (biodataMahasiswa[i].jekel==(konvert)){
                statusKetemu = true;
                lokasi = i;
                //biodataMahasiswa[lokasi] = MenampungBiodataMahasiswa; 
                //break;
                }
            }
            
            
        if (statusKetemu == true){ 
            //biodataMahasiswa[lokasi] = MenampungBiodataMahasiswa;
            //int panjang=lokasi;
            for (int i=0; i<=lokasi-1; i++){ 
            System.out.println("Data yang anda cari KETEMU di larik ke :"+ lokasi);
            System.out.println("------------------------------------------------------------------------");
            System.out.println("NAMA \t ALAMAT \t UMUR \t JEKEL \t HOBI1 \t HOBI2 \t HOBI3 \t \t IPK");
            System.out.println("------------------------------------------------------------------------");
            System.out.print (biodataMahasiswa[lokasi].nama + " \t");
            System.out.print (biodataMahasiswa[lokasi].alamat + " \t \t");
            System.out.print (biodataMahasiswa[lokasi].umur + " \t");
            System.out.print (biodataMahasiswa[lokasi].jekel + " \t");
            System.out.print (biodataMahasiswa[lokasi].hobi[0] + " \t");
            System.out.print (biodataMahasiswa[lokasi].hobi[1] + " \t");
            System.out.print (biodataMahasiswa[lokasi].hobi[2] + " \t");
            System.out.println(biodataMahasiswa[lokasi].ipk);
        }
    }
        else{ 
            System.out.println("maap, nama yang anda cari tidak ditemukan");
        }
    }
//------------------------------------------------------------------
//--- Fungsi untuk Mencari Data Secara Linear Search dan menghapusnya (Loop: For) ---
//------------------------------------------------------------------
public static void mencariHapusDataLinear(formatBiodata biodataMahasiswa[]){ 
    String kataKunci;
    int lokasi=-1;
    boolean statusKetemu=false;
//bagian memasukkan kata kunci ------------------------------------------
    Scanner masukan = new Scanner(System.in);
    System.out.print("Masukkan kata kunci pencarian : ");
    kataKunci = masukan.next();
//bagian mencari data satu persatu urut dari larik terdepan
        for (int i=0; i<= N-1; i++){
//mencocokkan biodataMahasiswa[i].nama == kataKunci
            if (biodataMahasiswa[i].nama.equals(kataKunci)){ 
                statusKetemu = true;
                lokasi = i;
                break;
                }
            }
        
            
        if (statusKetemu == true){ 
            System.out.println("Data yang anda cari KETEMU di larik ke :"+ lokasi);
            System.out.println("------------------------------------------------------------------------");
            System.out.println("NAMA \t ALAMAT \t UMUR \t JEKEL \t HOBI1 \t HOBI2 \t HOBI3 \t \t IPK");
            System.out.println("------------------------------------------------------------------------");
            System.out.print (biodataMahasiswa[lokasi].nama + " \t");
            System.out.print (biodataMahasiswa[lokasi].alamat + " \t \t");
            System.out.print (biodataMahasiswa[lokasi].umur + " \t");
            System.out.print (biodataMahasiswa[lokasi].jekel + " \t");
            System.out.print (biodataMahasiswa[lokasi].hobi[0] + " \t");
            System.out.print (biodataMahasiswa[lokasi].hobi[1] + " \t");
            System.out.print (biodataMahasiswa[lokasi].hobi[2] + " \t");
            System.out.println(biodataMahasiswa[lokasi].ipk);
//proses penghapusan setelah data di temukan
                int data=lokasi;
//bagian menggeser isi larik mulai dari T - Belakang selangkah ke depan
                for (int i=data; i<= N-1; i++){ 
                    biodataMahasiswa[i] = biodataMahasiswa[i+1];
                }
                System.out.println("Proses menghapus data ke-" + data + " selesai.");
//memperbaharui banyaknya data (N), banyaknya data berkurang satu-------
                N--;
                tampilkanData(biodataMahasiswa);
        }
        else{ 
            System.out.println("proses penghapusan gagal karena data "+kataKunci+" tidak di temukan");
        }
    }
//------------------------------------------------------
//--- Fungsi untuk Mengurutkan Data (BubbleSort) ---
//------------------------------------------------------
public static void mengurutkanDataBubble(formatBiodata biodataMahasiswa[]){
    formatBiodata biodataSementara = new formatBiodata();
    int indeksTerakhir = N-1;
    for (int j=0;j<=indeksTerakhir -1; j++)
    for (int i=0; i<=indeksTerakhir -1 -j; i++){
// perintah dibawah ini identik dengan if (nama[i]>nama[i+1])
        if (biodataMahasiswa[i].ipk.compareTo(biodataMahasiswa[i+1].ipk) > 0){ 
            biodataSementara = biodataMahasiswa[i];
            biodataMahasiswa[i] = biodataMahasiswa[i+1];
            biodataMahasiswa[i+1] = biodataSementara;
        }
    }
    tampilkanData(biodataMahasiswa);
}
//------------------------------------------------------
//--- Fungsi untuk Mengurutkan Data (Selection) ---
//------------------------------------------------------
public static void mengurutkanDataSelection(formatBiodata biodataMahasiswa[]){
    formatBiodata biodataSementara = new formatBiodata();
    String teksTerkecil = "";
    int lokasi=0;
//bagian mengurutkan dengan teknik selection
    for (int i=0; i<=N-2; i++){
//data pertama yang dibaca dianggap data terkecil
        teksTerkecil = "zzzzzzz";
//menentukan bilangan terkecil mulai larik ke i+1 sampai N-1
            for (int S=i+1; S<=N-1; S++){
                if (biodataMahasiswa[S].nama.compareTo(teksTerkecil)<0){ 
                    //jika data[S] adlh bilangan terkecil, simpan di
                    teksTerkecil
                    teksTerkecil = biodataMahasiswa[S].nama;
                    //mencatat posisi dimana data terkecil ada
                    lokasi = S;
                }
            }
//membandingkan data[lokasi] yang adalah data terkecil,
// versus data[i] yang adalah ‘diagonal ke-i'
        if (biodataMahasiswa[i].nama.compareTo(biodataMahasiswa[lokasi].nama)>0){{ 
            //tukar posisi
                biodataSementara = biodataMahasiswa[i];
                biodataMahasiswa[i] = biodataMahasiswa[lokasi];
                biodataMahasiswa[lokasi] = biodataSementara;
            }
        }
    }
    tampilkanData(biodataMahasiswa);
}
//------------------------------------------------------
//--- Fungsi untuk Mengurutkan Data (Insertion) ---
//------------------------------------------------------
public static void mengurutkanDataInsertion(formatBiodata biodataMahasiswa[]){
    formatBiodata biodataSementara = new formatBiodata();
//untuk menentukan awal dari data sisi kanan (sisi yg masih berantakan)
    int awal;
//untuk mencari posisi yg tepat pada sisi kiri (sisi yg sudah berurutan)
    int cari;
    awal = 1;
    while (awal <=N-1){
        biodataSementara = biodataMahasiswa[awal];
        cari = awal-1;
        //cari akan bergerak dari kanan (awal-1) ke kiri
            while ( cari >= 0){
                //( biodataMahasiswa[cari].nama > biodataSementara.nama )
                if (biodataMahasiswa[cari].nama.compareTo(biodataSementara.nama)>0){
                    biodataMahasiswa[cari+1] = biodataMahasiswa[cari];
                    biodataMahasiswa[cari] = biodataSementara;
                    cari--; //cari digeser kekiri 1 langkah
                }
                else{ 
                    biodataMahasiswa[cari+1] = biodataSementara;
                    // perintah ini untuk keluar dari loop while
                    cari=-1;
                }
            }
            awal++;
        }
        tampilkanData(biodataMahasiswa);
    }
//--------------------------------------------------
//--- Fungsi untuk menampilkan data ---
//--------------------------------------------------
public static void tampilkanData(formatBiodata biodataMahasiswa[])
{
//bagian menampilkan isi struktur Larik --------------------------
System.out.println("------------------------------------------------------------------------");
System.out.println("NAMA \t ALAMAT \t UMUR \t JEKEL \t HOBI1 \t HOBI2 \t HOBI3 \t \t IPK");
System.out.println("------------------------------------------------------------------------");
for (int i=0; i<=N-1; i++){ 
    System.out.print (biodataMahasiswa[i].nama + " \t");
    System.out.print (biodataMahasiswa[i].alamat + " \t \t");
    System.out.print (biodataMahasiswa[i].umur + " \t");
    System.out.print (biodataMahasiswa[i].jekel + " \t");
    System.out.print (biodataMahasiswa[i].hobi[0] + " \t");
    System.out.print (biodataMahasiswa[i].hobi[1] + " \t");
    System.out.print (biodataMahasiswa[i].hobi[2] + " \t");
    System.out.println(biodataMahasiswa[i].ipk);
    }
System.out.println("---------------------------------------------");
}
//--------------------------------------------------
//--- Program Utama ---
//--------------------------------------------------
public static void main(String[] args)
{ //bagian deklarasi record berbasis LARIK -----------------------
Scanner melebu = new Scanner(System.in);
    System.out.print("masukan banyaknya data yang akan di input : ");
    N = melebu.nextInt();
    if(N>20){
        System.out.print("maksimal data yang dapat di tampung adalah 20");
        System.out.println(" ");
        pertemuan3.main(args); 
    }
    else if(N==0){
        System.out.print("Input yang anda masukkan tidak sesuai");
        System.out.println(" ");
        pertemuan3.main(args); 
    }
    else{
    formatBiodata biodataMahasiswa[] = new formatBiodata[20];
    
    
        for(byte x=0;x<(N+1);x++){
            biodataMahasiswa[x] = new formatBiodata();
            }
ngentriData(biodataMahasiswa);
tampilkanData(biodataMahasiswa);
String jawab="Y";
byte plh=0;
            while(jawab.equalsIgnoreCase("Y")){
                System.out.print("Tambah data(Y/N) : ");
                jawab=melebu.next();
                    if(jawab.equalsIgnoreCase("N")){
                        System.out.println("===menu===");
                        System.out.println("1.  hapus data di depan");
                        System.out.println("2.  hapus data di tengah");
                        System.out.println("3.  hapus data di belakang");
                        System.out.println("4.  pencarian data linear(WHILE)");
                        System.out.println("5.  pencarian data linear(FOR)");
                        System.out.println("6.  pencarian data Biner");
                        System.out.println("7.  pencarian data Bersyarat");
                        System.out.println("8.  Bubblesort");
                        System.out.println("9.  Selection Sort[error]");
                        System.out.println("10. InsertionSort");
                        //System.out.println("8. hapus data lewat pencarian");
                        System.out.print("pilih :");
                        plh=melebu.nextByte();
                            if(plh==1){
                                hapusDataDiDepan(biodataMahasiswa);
                            }
                            else if(plh==2){
                                hapusDataDiTengah(biodataMahasiswa);
                            }
                            else if(plh==3){
                                hapusDataDiBelakang(biodataMahasiswa);
                            }
                            else if(plh==4){
                                cariDataLinear(biodataMahasiswa);//WHILE
                            }
                            else if(plh==5){
                                mencariDataLinear(biodataMahasiswa);//FOR
                            }
                            else if(plh==6){
                                mencariDataBiner(biodataMahasiswa);
                            }
                            else if(plh==7){
                                mencariDataBersyarat(biodataMahasiswa);
                            }
                            else if(plh==8){
                                mengurutkanDataBubble(biodataMahasiswa);
                            }
                            else if(plh==9){
                                mengurutkanDataSelection(biodataMahasiswa);
                            }
                            else if(plh==10){
                                mengurutkanDataInsertion(biodataMahasiswa);
                            }
                            else{
                                System.out.println("input yang anda masukkan salah");
                            }
                        break;
                        }
                   else{
                        tambahData(biodataMahasiswa);
                        }
            }
        }
 }
}


