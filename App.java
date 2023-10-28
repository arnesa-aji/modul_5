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
                        System.out.println("8.  Bubblesort");
                        //System.out.println("8. hapus data lewat pencarian");
                        System.out.print("pilih :");
                        plh=melebu.nextByte();
                            if(plh==8){
                                mengurutkanDataBubble(biodataMahasiswa);
                            }
                            else{
                                System.out.println("input yang anda masukkan salah");
                            }
                        break;
                        }
                   else{
                        //tambahData(biodataMahasiswa);
                        }
            }
        }
 }
}


