# FakeGen

[![Java Version](https://img.shields.io/badge/java-17+-blue.svg)](https://www.oracle.com/java/technologies/downloads/)
[![Maven Central](https://img.shields.io/maven-central/v/com.fakegen/fakegen.svg)](https://search.maven.org/artifact/com.fakegen/fakegen)
[![License](https://img.shields.io/badge/license-MIT-green.svg)](LICENSE)
[![Build Status](https://github.com/karyaboyraz/fakegen/actions/workflows/maven.yml/badge.svg)](https://github.com/karyaboyraz/fakegen/actions)

FakeGen is a comprehensive Java library for generating realistic fake data. It provides a wide range of data providers to generate various types of fake data for testing, development, and demonstration purposes.

## Table of Contents

- [Features](#features)
- [Requirements](#requirements)
- [Installation](#installation)
- [Usage](#usage)
- [Available Providers](#available-providers)
- [Troubleshooting](#troubleshooting)
- [Contributing](#contributing)
- [License](#license)
- [Author](#author)
- [Acknowledgments](#acknowledgments)

## Features

- **Multi-language Support**: Supports multiple locales for localized data generation
- **Extensive Data Providers**: Includes providers for various data types:
  - Addresses
  - Names
  - Companies
  - Internet-related data
  - Books
  - Colors
  - Food
  - Music
  - Phone numbers
  - Weather
  - Films
  - Animals
  - Vehicles
  - Science
  - System information
  - Git-related data
  - Cryptocurrency
  - Commerce
  - Code
  - Dates
  - Finance
  - Artists
  - Apps
  - Helpers
  - Boolean values
  - Images
  - Numbers
  - Strings
  - Words

## Requirements

- Java 17 or higher
- Maven 3.6 or higher (for Maven projects)
- Gradle 7.0 or higher (for Gradle projects)

## Installation

### Maven
Add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>com.fakegen</groupId>
    <artifactId>fakegen</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Gradle
Add the following dependency to your `build.gradle`:

```gradle
implementation 'com.fakegen:fakegen:1.0.0'
```

## Usage

### Basic Usage

```java
// Create a new instance with default locale (Turkish)
FakeGen fakeGen = new FakeGen();

// Generate a random first name
String firstName = fakeGen.name().firstName();

// Generate a random street address
String address = fakeGen.address().streetAddress();

// Generate a random email
String email = fakeGen.internet().email();
```

### Using Different Locales

```java
// Create a new instance with a specific locale
FakeGen fakeGen = new FakeGen(FakerLocale.EN_US);

// Generate localized data
String localizedName = fakeGen.name().firstName();
```

## Available Providers

### Address Provider
```java
String streetAddress = fakeGen.address().streetAddress();
String city = fakeGen.address().city();
String country = fakeGen.address().country();
String postalCode = fakeGen.address().postalCode();
String state = fakeGen.address().state();
```

### Name Provider
```java
String firstName = fakeGen.name().firstName();
String lastName = fakeGen.name().lastName();
String fullName = fakeGen.name().fullName();
String prefix = fakeGen.name().prefix();
String suffix = fakeGen.name().suffix();
```

### Internet Provider
```java
String email = fakeGen.internet().email();
String url = fakeGen.internet().url();
String ipAddress = fakeGen.internet().ipAddress();
String username = fakeGen.internet().username();
String domainName = fakeGen.internet().domainName();
```

### Company Provider
```java
String companyName = fakeGen.company().name();
String industry = fakeGen.company().industry();
String catchPhrase = fakeGen.company().catchPhrase();
String buzzword = fakeGen.company().buzzword();
String bs = fakeGen.company().bs();
```

### Finance Provider
```java
String creditCardNumber = fakeGen.finance().creditCardNumber();
String currency = fakeGen.finance().currency();
String bankName = fakeGen.finance().bankName();
String iban = fakeGen.finance().iban();
String bic = fakeGen.finance().bic();
```

## Troubleshooting

### Common Issues

1. **Locale Not Found**
   - Ensure you're using a supported locale
   - Check the spelling of the locale constant

2. **NullPointerException**
   - Make sure you've initialized the FakeGen instance
   - Check if the provider you're trying to use exists

3. **Memory Issues**
   - If generating large amounts of data, consider using streams
   - Release resources when done with large data sets

## Contributing

We welcome contributions! Here's how you can help:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

Please make sure to:
- Follow the existing code style
- Add tests for new features
- Update documentation as needed
- Keep commits clean and focused

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Author

- Karya Boyraz

## Acknowledgments

- Inspired by various fake data generation libraries
- Thanks to all contributors and users
- Special thanks to the open source community for their valuable tools and libraries
