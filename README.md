# FakeGen

A simple and efficient fake data generator for Java applications with multi-language support.

## Features

- Generate realistic fake data for testing and development
- Support for multiple locales (currently EN-US and TR-TR)
- Various data categories:
  - Names (first name, last name, full name, username)
  - Addresses (street, city, country, postal code, etc.)
  - Companies (company name, industry, catch phrase)
  - Internet (email, URL, IP address)

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
        <version>1.0-SNAPSHOT</version>
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

## Usage

```java
import com.fakegen.Faker;
import com.fakegen.locale.FakerLocale;

// Create a Faker instance with Turkish locale
Faker faker = new Faker(FakerLocale.TR_TR);

// Generate fake data
String fullName = faker.name().fullName();
String address = faker.address().fullAddress();
String company = faker.company().companyName();
String email = faker.internet().email();

// Switch to English locale
faker.setLocale(FakerLocale.EN_US);
```

## Requirements

- Java 11 or higher
- Maven for dependency management

## Building from Source

```bash
mvn clean install
```

## License

This project is open source and available under the MIT License.
