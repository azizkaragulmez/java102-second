public class Main {
    public static void main(String[] args) {
        //Çok sık kullanıcağımız bir yapıdır.
        //içerisinde tablo bulunmaktadır.
        System.out.println("Hello world!");



        /*
        Java'da Collection, nesneleri depolamak ve yönetmek için kullanılan bir çerçevedir (framework). Java Collections Framework (JCF), çeşitli veri yapıları ve algoritmalar sunarak, nesne gruplarını manipüle etmek ve yönetmek için standart bir yol sağlar. Bu framework, Java'nın java.util paketinde bulunur ve veri toplama işlemlerini (ekleme, silme, arama, sıralama vb.) kolaylaştırır.

Java Collection Framework'ün Temel Bileşenleri
Java Collection Framework, üç ana arayüze dayanır: List, Set, ve Map. Bunlar, farklı veri yapılarını ve davranışları temsil eder. Her biri farklı bir koleksiyon türü sunar:

List Arayüzü:

Açıklama: Sıralı ve tekrarlı öğeleri saklamak için kullanılır. Listeye eklenen her öğe belirli bir sırayı takip eder.
Özellikler: Aynı değere sahip birden fazla öğe (duplicate) içerebilir ve öğeler indekse dayalı olarak erişilebilir.
Implementasyonlar:
ArrayList: Dinamik diziler kullanır ve rastgele erişim için optimize edilmiştir.
LinkedList: Çift yönlü bağlı liste kullanır, ekleme ve silme işlemleri için optimize edilmiştir.
Vector: Eski bir koleksiyon sınıfıdır; synchronized bir versiyonu olan Stack'i içerir.
Set Arayüzü:

Açıklama: Tekrarsız (unique) öğeleri saklamak için kullanılır. Sıra önemli değildir.
Özellikler: Aynı öğeden birden fazla içeremez (no duplicates allowed).
Implementasyonlar:
HashSet: Hashing mekanizması kullanarak öğeleri saklar; sırasızdır ve null değerleri içerebilir.
LinkedHashSet: HashSet'in sıralı versiyonudur; ekleme sırasını korur.
TreeSet: Öğeleri sıralı bir şekilde saklar ve sıralama için NavigableSet arayüzünü kullanır.
Map Arayüzü:

Açıklama: Anahtar-değer (key-value) çiftlerini saklamak için kullanılır. Her anahtar benzersizdir.
Özellikler: Aynı anahtara sahip birden fazla değer olamaz.
Implementasyonlar:
HashMap: Anahtarları ve değerleri hashing kullanarak saklar; sırasızdır ve null anahtarlar ve değerler içerebilir.
LinkedHashMap: HashMap'in sıralı versiyonudur; ekleme sırasını korur.
TreeMap: Anahtarları sıralı bir şekilde saklar ve sıralama için NavigableMap arayüzünü kullanır.
Collection Arayüzünün Metotları
Collection arayüzü, tüm koleksiyon sınıflarının ortak olarak kullanabileceği bazı temel metotlar sunar:

add(E e): Koleksiyona bir öğe ekler.
remove(Object o): Koleksiyondan belirtilen öğeyi kaldırır.
size(): Koleksiyondaki öğelerin sayısını döner.
isEmpty(): Koleksiyonun boş olup olmadığını kontrol eder.
contains(Object o): Koleksiyonun belirtilen öğeyi içerip içermediğini kontrol eder.
iterator(): Koleksiyon üzerinde yineleme (iteration) yapabilmek için bir iterator döner.
Neden Java Collections Kullanılır?
Kapsamlı Veri Yapıları: Java Collections Framework, farklı veri yapıları (diziler, bağlı listeler, ağaçlar, kümeler vb.) sağlar.
Yeniden Kullanılabilirlik ve Bakım Kolaylığı: Collection sınıfları genel ve esnektir, bu da kodun yeniden kullanılabilirliğini ve bakımını kolaylaştırır.
Performans Optimizasyonu: Farklı koleksiyon türleri, farklı türde operasyonlar için optimize edilmiştir (örneğin, arama, ekleme, silme).
Standartlaştırılmış Yaklaşım: Tüm koleksiyon türleri ortak bir arayüzü takip ettiğinden, kodu öğrenmek ve kullanmak kolaydır.
         */
    }
}