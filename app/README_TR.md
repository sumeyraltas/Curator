# 🏛️ Curator — Sanat Tarihi ve Dijital Müze

<p align="center">
  <img src="screenshots/Screenshot_20260908_141920.png" alt="Curator Keşfet Ekranı" width="280" />
</p>

<p align="center">
  <strong>Dünyaca ünlü başyapıtları, sanat akımlarını ve yapay zekâ destekli küratör analizlerini parmaklarınızın ucuna getiren modern bir dijital sanat müzesi uygulaması.</strong>
</p>

<p align="center">
  <a href="README.md"><strong>Switch to English README</strong></a>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Platform-Android-3DDC84?logo=android&logoColor=white" alt="Platform" />
  <img src="https://img.shields.io/badge/Dil-Kotlin-7F52FF?logo=kotlin&logoColor=white" alt="Dil" />
  <img src="https://img.shields.io/badge/Arayüz-Jetpack_Compose_Material_3-4285F4?logo=jetpackcompose&logoColor=white" alt="Jetpack Compose" />
  <img src="https://img.shields.io/badge/Veritabanı-Room_SQLite-00599C?logo=sqlite&logoColor=white" alt="Room" />
  <img src="https://img.shields.io/badge/Ağ-Retrofit_2_%2B_Moshi-blue" alt="Retrofit" />
  <img src="https://img.shields.io/badge/Mimari-MVVM_%2B_Flow-brightgreen" alt="Mimari" />
</p>

---

## 📖 İçindekiler
1. [Genel Bakış](#genel-bakış)
2. [Öne Çıkan Özellikler](#öne-çıkan-özellikler)
3. [Uygulama Ekran Görüntüleri](#uygulama-ekran-görüntüleri)
4. [Mimari ve Teknolojiler](#mimari-ve-teknolojiler)
5. [Proje Dizin Yapısı](#proje-dizin-yapısı)
6. [Kurulum ve Çalıştırma](#kurulum-ve-çalıştırma)


---

## Genel Bakış
**Curator**, sanatseverler, öğrenciler ve müzebilimi meraklıları için geliştirilmiş modern bir Android dijital sanat müzesi uygulamasıdır. **%100 Kotlin** ve **Jetpack Compose (Material Design 3)** mimarisiyle sıfırdan inşa edilen Curator, klasik sanat mirasını günümüzün akıcı mobil teknolojileriyle buluşturur.

Kullanıcılar her gün özenle seçilen **Günün Başyapıtı** ile tanışabilir, **Louvre, MoMA ve Prado** gibi dünyanın önde gelen müzelerinin koleksiyonlarını gezebilir, **Rönesans, Empresyonizm ve Barok** gibi akımları derinlemesine inceleyebilir, **Yapay Zekâ Küratör Analizleri** alabilir ve **Room Veritabanı** sayesinde tamamen çevrimdışı çalışan **Kişisel Koleksiyon** oluşturup kendi küratörlük notlarını kaydedebilirler.

---

## Öne Çıkan Özellikler

* 🌟 **Günün Başyapıtı (Masterpiece of the Day)**: Her gün öne çıkarılan başyapıt (ör. Van Gogh - *Yıldızlı Gece*), yüksek çözünürlüklü görseli, sanatçı bilgisi ve tek dokunuşla başlatılabilen derin sanat analizi.
* 🏛️ **Müzelere Göre Keşfet (Explore by Museum)**: Dünyanın en prestijli kültür merkezlerine ayrılmış özel bölümler: *Louvre Müzesi* (Paris), *MoMA* (New York), *Prado Müzesi* (Madrid) ve *Art Institute of Chicago*.
* 🎨 **Sanat Akımları (Art Movements)**: Rönesans'tan Barok ve Empresyonizme kadar tüm sanatsal dönemlerin tarihsel bağlamını ve karakteristik özelliklerini anlatan kartlar.
* 🔍 **Akıllı Arama ve Filtreler (Search & Quick Filter Chips)**: Eser adı, ressam veya üsluba göre anında filtreleme sağlayan yatay etiketler (`Van Gogh`, `19. Yüzyıl`, `Paris`, `Empresyonizm`, `Barok`, `Rönesans`).
* 🖼️ **Yüksek Çözünürlüklü Detay ve Büyüteç (Lightbox)**: Eserleri tam ekranda yakınlaştırma imkanı, müze kayıtları (Yapılış Yılı, Teknik/Malzeme, Ebatlar, Bulunduğu Müze ve Açıklama).
* ✨ **Yapay Zekâ Küratör Analizleri (AI Curator Insights)**: Eserin renk teorisi, kompozisyon dinamikleri, fırça işçiliği ve dönemsel önemine dair yapay zekâ destekli derinlemesine değerlendirmeler.
* 📑 **Kişisel Koleksiyon ve Notlar (Personal Collection & Notes)**: Beğenilen eserleri **Room Veritabanı** ile cihazda çevrimdışı saklama, eserlere özel küratör notları ekleme, düzenleme ve silme.
* 🏺 **Müze Temalı Özel Arayüz (Material 3 UI)**: Müzelerin sakin atmosferini yansıtan sıcak bej ve bordo tonları, zarif serif tipografi ve kenardan kenara (Edge-to-Edge) modern yerleşim.

---

## Uygulama Ekran Görüntüleri

|               1. Keşfet ve Günün Başyapıtı               | 2. Eser Detayları & Bilgiler | 3. Sanat Akımları ve Müzeler |
|:--------------------------------------------------------:| :---: | :---: |
| <img src="Screenshot_20260908_141920.png" width="240" /> | <img src="screenshots/Screenshot_20260908_141929.png" width="240" /> | <img src="screenshots/Screenshot_20260908_141948.png" width="240" /> |
| *Curator ana sayfası: "Yıldızlı Gece" ve sanat akımları* | *Eser detay kartı (Yıl, Teknik, Ebatlar, Müze ve Tarihçe)* | *Sanat akımı kartları ve dünyaca ünlü müze rozetleri* |

|                4. Küratörlü Galeri Akışı                 | 5. Kişisel Koleksiyon & Notlar | 6. Arama ve Filtre Çipleri | 7. Akıma Göre Listeleme |
|:--------------------------------------------------------:| :---: | :---: | :---: |
| <img src="Screenshot_20260908_141953.png" width="220" /> | <img src="screenshots/Screenshot_20260908_142015.png" width="220" /> | <img src="screenshots/Screenshot_20260908_142026.png" width="220" /> | <img src="screenshots/Screenshot_20260908_142039.png" width="220" /> |
|    *Yüksek çözünürlüklü eser kartlarıyla sonsuz akış*    | *Favoriye eklenen eserler, not ekleme ve düzenleme* | *Arama çubuğu ve hızlı filtreleme butonları* | *Empresyonizm ve Barok gibi akımlara göre filtreleme* |

---

## Mimari ve Teknolojiler

Uygulama, Google tarafından önerilen modern Android mimarisi ilkelerine (**MVVM - Model-View-ViewModel**) ve **Tek Yönlü Veri Akışına (Unidirectional Data Flow)** tam uyumludur.

* **Programlama Dili**: Kotlin 2.0+
* **Arayüz (UI)**: Jetpack Compose, Material Design 3 (M3)
* **Görsel Yükleme & Önbellek**: Coil Compose (asenkron yükleme ve yumuşak geçiş animasyonları)
* **Yerel Veritabanı**: Jetpack Room Database (KSP ile derleme zamanı doğrulama)
* **Ağ Katmanı**: Retrofit 2 + Moshi Converter + OkHttp Logging
* **Asenkron İşlemler**: Kotlin Coroutines & StateFlow
* **Navigasyon**: Jetpack Navigation Compose (Tip güvenli rota yönetimi)
* **Test Altyapısı**: Robolectric (JVM birim testleri) & Roborazzi (Görsel regresyon testleri)

---

## Proje Dizin Yapısı

```
├── app
│   ├── src
│   │   ├── main
│   │   │   ├── java/com/example
│   │   │   │   ├── data
│   │   │   │   │   ├── api          # API servisleri ve seçilmiş sanat veri tabanı
│   │   │   │   │   ├── db           # Room veritabanı, DAO ve Entity sınıfları
│   │   │   │   │   ├── model        # Sanat eseri, sanat akımı ve müze veri modelleri
│   │   │   │   │   └── repository   # Uzak sunucu ile yerel veritabanını birleştiren depo
│   │   │   │   ├── ui
│   │   │   │   │   ├── components   # Tekrar kullanılabilir arayüz bileşenleri (Kartlar, Lightbox)
│   │   │   │   │   ├── navigation   # Sayfalar arası geçiş ve alt menü çubuğu
│   │   │   │   │   ├── screens      # Discover, Detail, Search ve Collection ekranları
│   │   │   │   │   ├── theme        # Renk paleti, tipografi ve tema tanımları
│   │   │   │   │   └── viewmodel    # Ekran durumlarını yöneten ViewModel sınıfları
│   │   │   │   └── MainActivity.kt  # Uygulama başlangıç noktası (Activity)
│   │   │   └── res                  # Görseller, ikonlar ve metin kaynakları
│   │   └── test                     # Robolectric ve ekran görüntüsü testleri
├── screenshots                      # Uygulamanın yüksek çözünürlüklü ekran görüntüleri
├── build.gradle.kts                 # Kök derleme yapılandırması
└── settings.gradle.kts              # Proje ayarları
```

---

## Kurulum ve Çalıştırma

### Gereksinimler
* **Android Studio**: Ladybug (2024.2.1) veya daha yeni bir sürüm
* **JDK**: Java Development Kit 17 veya üzeri
* **Android SDK**: Hedef SDK 36 (Minimum SDK 24)

### Adım Adım Kurulum
1. Projeyi klonlayın veya indirin:
   ```bash
   git clone https://github.com/kullanici-adiniz/curator-android.git
   cd curator-android
   ```
2. Android Studio'yu açıp projeyi içeri aktarın (**Open**).
3. Gradle paketlerinin indirilmesini ve senkronizasyonu tamamlayın.
4. Bir Android Emülatörü veya USB ile bağlı fiziksel bir Android cihaz seçin.
5. **Çalıştır (`Shift + F10`)** butonuna basarak uygulamayı derleyip başlatın.
   Terminal üzerinden yüklemek için:
   ```bash
   ./gradlew installDebug
   ```

---