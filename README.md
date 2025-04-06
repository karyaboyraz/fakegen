# FakeGen

A simple and efficient fake data generator for Java applications with multi-language support.

## Features

- Generate realistic fake data for testing and development
- Support for multiple locales (currently EN-US and TR-TR)
- Various data categories:
  - Names (first name, last name, full name)
  - Addresses (street, city, district, country, postal code)
  - Companies (company name, industry)
  - Internet (email, username)

## Installation

Add the following to your project's `pom.xml`:

```xml
<repositories>
    <repository>
        <id>github</id>
        <url>https://maven.pkg.github.com/karyaboyraz/fakegen</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.fakegen</groupId>
        <artifactId>fakegen</artifactId>
        <version>1.0.0</version>
    </dependency>
</dependencies>
```

Also, make sure to add your GitHub credentials to your `~/.m2/settings.xml`:

```xml
<settings>
  <servers>
    <server>
      <id>github</id>
      <username>YOUR_GITHUB_USERNAME</username>
      <password>YOUR_GITHUB_TOKEN</password>
    </server>
  </servers>
</settings>
```

To generate a GitHub token with the required permissions:
1. Go to GitHub.com → Settings → Developer settings → Personal access tokens → Tokens (classic)
2. Click "Generate new token" → "Generate new token (classic)"
3. Select the following permissions: `read:packages`, `write:packages`
4. Copy the generated token and use it in your settings.xml

## Usage

```java
import com.fakegen.FakeGen;
import com.fakegen.locale.FakerLocale;

// Create a FakeGen instance with Turkish locale
FakeGen fakeGen = new FakeGen(FakerLocale.TR_TR);

// Generate fake data
String fullName = fakeGen.name().fullName();         // "Ahmet Yılmaz"
String address = fakeGen.address().fullAddress();     // "1234 Atatürk Caddesi, İstanbul/Kadıköy, Türkiye 34700"
String company = fakeGen.company().companyName();     // "Yılmaz Teknoloji A.Ş."
String email = fakeGen.internet().email();           // "ahmet.yilmaz@example.com"

// Switch to English locale
fakeGen.setLocale(FakerLocale.EN_US);
String englishName = fakeGen.name().fullName();      // "John Smith"
```

## Available Data Types

### Name
- `fullName()`
- `firstName()`
- `lastName()`

### Address
- `fullAddress()`
- `street()`
- `city()`
- `district()`
- `country()`
- `postalCode()`
- `districtOfCity(String city)`

### Company
- `companyName()`
- `industry()`

### Internet
- `email()`
- `username()`

## Building from Source

```bash
git clone https://github.com/karyaboyraz/fakegen.git
cd fakegen
mvn clean install
```

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is open source and available under the MIT License.
