# FakeGen

FakeGen, Java uygulamaları için basit ve verimli bir sahte veri üretecidir. Çoklu dil desteği ile birlikte gelir ve çeşitli veri türleri için rastgele veriler üretir.

## Özellikler

- Çoklu dil desteği (TR, EN, DE, FR, ES, IT, PT, RU, JA, KO, ZH, AR)
- Çeşitli veri türleri için rastgele veri üretimi
- Kolay kullanım
- Yüksek performans
- Genişletilebilir yapı

## Kurulum

### Maven

```xml
<dependency>
    <groupId>com.fakegen</groupId>
    <artifactId>fakegen</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Kullanım

```java
// Varsayılan dil (Türkçe) ile başlatma
FakeGen fakeGen = new FakeGen();

// Belirli bir dil ile başlatma
FakeGen fakeGen = new FakeGen(FakerLocale.EN_US);

// İsim üretimi
String firstName = fakeGen.name().firstName();
String lastName = fakeGen.name().lastName();
String fullName = fakeGen.name().fullName();

// Adres üretimi
String streetAddress = fakeGen.address().streetAddress();
String city = fakeGen.address().city();
String country = fakeGen.address().country();
String fullAddress = fakeGen.address().fullAddress();

// Şirket üretimi
String companyName = fakeGen.company().name();
String industry = fakeGen.company().industry();
String catchPhrase = fakeGen.company().catchPhrase();

// İnternet üretimi
String email = fakeGen.internet().email();
String username = fakeGen.internet().username();
String url = fakeGen.internet().url();

// Kitap üretimi
String title = fakeGen.book().title();
String author = fakeGen.book().author();
String publisher = fakeGen.book().publisher();

// Renk üretimi
String colorName = fakeGen.color().name();
String hexColor = fakeGen.color().hex();
String rgbColor = fakeGen.color().rgb();

// Yemek üretimi
String ingredient = fakeGen.food().ingredient();
String dish = fakeGen.food().dish();
String recipe = fakeGen.food().recipe();

// Müzik üretimi
String genre = fakeGen.music().genre();
String instrument = fakeGen.music().instrument();
String key = fakeGen.music().key();

// Telefon numarası üretimi
String cellPhone = fakeGen.phoneNumber().cellPhone();
String landline = fakeGen.phoneNumber().landline();
String international = fakeGen.phoneNumber().international();

// Hava durumu üretimi
String description = fakeGen.weather().description();
String forecast = fakeGen.weather().forecast();

// Lorem ipsum üretimi
String word = fakeGen.lorem().word();
String sentence = fakeGen.lorem().sentence(10);
String paragraph = fakeGen.lorem().paragraph(5);
String text = fakeGen.lorem().text(3);

// Film üretimi
String filmTitle = fakeGen.film().title();
String director = fakeGen.film().director();
String actor = fakeGen.film().actor();
String plot = fakeGen.film().plot();
```

## Veri Türleri

- İsimler (ad, soyad, tam ad, önek, sonek, unvan)
- Adresler (sokak, şehir, eyalet, ülke, posta kodu)
- Şirketler (isim, sektör, slogan, açıklama)
- İnternet (e-posta, kullanıcı adı, alan adı, URL, IP adresi)
- Kitaplar (başlık, yazar, yayınevi, tür, ISBN)
- Renkler (isim, HEX, RGB, HSL)
- Yemekler (malzeme, baharat, ölçü, yemek, tarif)
- Müzik (tür, enstrüman, nota, akor, ölçek)
- Telefon numaraları (cep, sabit, uluslararası)
- Hava durumu (açıklama, sıcaklık, nem, rüzgar)
- Lorem ipsum (kelime, cümle, paragraf, metin)
- Filmler (başlık, yönetmen, oyuncu, tür, alıntı)

## Katkıda Bulunma

1. Bu depoyu fork edin
2. Yeni bir özellik dalı oluşturun (`git checkout -b feature/amazing-feature`)
3. Değişikliklerinizi commit edin (`git commit -m 'Add some amazing feature'`)
4. Dalınıza push edin (`git push origin feature/amazing-feature`)
5. Bir Pull Request açın

## Lisans

Bu proje MIT lisansı altında lisanslanmıştır. Daha fazla bilgi için `LICENSE` dosyasına bakın.
