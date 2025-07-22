
<div align="right">
  <details>
    <summary >🌐 Language</summary>
    <div>
      <div align="center">
        <a href="https://openaitx.github.io/view.html?user=daniel-rusu&project=pods4k&lang=en">English</a>
        | <a href="https://openaitx.github.io/view.html?user=daniel-rusu&project=pods4k&lang=zh-CN">简体中文</a>
        | <a href="https://openaitx.github.io/view.html?user=daniel-rusu&project=pods4k&lang=zh-TW">繁體中文</a>
        | <a href="https://openaitx.github.io/view.html?user=daniel-rusu&project=pods4k&lang=ja">日本語</a>
        | <a href="https://openaitx.github.io/view.html?user=daniel-rusu&project=pods4k&lang=ko">한국어</a>
        | <a href="https://openaitx.github.io/view.html?user=daniel-rusu&project=pods4k&lang=hi">हिन्दी</a>
        | <a href="https://openaitx.github.io/view.html?user=daniel-rusu&project=pods4k&lang=th">ไทย</a>
        | <a href="https://openaitx.github.io/view.html?user=daniel-rusu&project=pods4k&lang=fr">Français</a>
        | <a href="https://openaitx.github.io/view.html?user=daniel-rusu&project=pods4k&lang=de">Deutsch</a>
        | <a href="https://openaitx.github.io/view.html?user=daniel-rusu&project=pods4k&lang=es">Español</a>
        | <a href="https://openaitx.github.io/view.html?user=daniel-rusu&project=pods4k&lang=it">Italiano</a>
        | <a href="https://openaitx.github.io/view.html?user=daniel-rusu&project=pods4k&lang=ru">Русский</a>
        | <a href="https://openaitx.github.io/view.html?user=daniel-rusu&project=pods4k&lang=pt">Português</a>
        | <a href="https://openaitx.github.io/view.html?user=daniel-rusu&project=pods4k&lang=nl">Nederlands</a>
        | <a href="https://openaitx.github.io/view.html?user=daniel-rusu&project=pods4k&lang=pl">Polski</a>
        | <a href="https://openaitx.github.io/view.html?user=daniel-rusu&project=pods4k&lang=ar">العربية</a>
        | <a href="https://openaitx.github.io/view.html?user=daniel-rusu&project=pods4k&lang=fa">فارسی</a>
        | <a href="https://openaitx.github.io/view.html?user=daniel-rusu&project=pods4k&lang=tr">Türkçe</a>
        | <a href="https://openaitx.github.io/view.html?user=daniel-rusu&project=pods4k&lang=vi">Tiếng Việt</a>
        | <a href="https://openaitx.github.io/view.html?user=daniel-rusu&project=pods4k&lang=id">Bahasa Indonesia</a>
      </div>
    </div>
  </details>
</div>

# pods4k

[![Maven Central][maven-central-badge]][maven-central-url]
[![Licence][license-badge]][license-url]
![Top language][top-language-badge]
![Build Status][build-status-badge]
[![Stargazers][stars-badge]][stars-url]

## Performance-oriented data structures for Kotlin

A collection of performance-oriented data structures providing performance and efficiency that might appear to be
impossible at first glance.

If you find this library useful, please consider giving it
a [![GitHub stars](https://img.shields.io/github/stars/daniel-rusu/pods4k?label=Star)](https://github.com/daniel-rusu/pods4k)
on [GitHub](https://github.com/daniel-rusu/pods4k) and sharing it with others.

## Installation

[![Latest Version][latest-version-shield]][maven-central-url] available on Maven Central:

**Gradle:**

```kotlin
repositories {
    mavenCentral()
}
dependencies {
    implementation("com.danrusu.pods4k:pods4k:<latest_version>")
}
```

**Maven:**

```xml

<dependency>
    <groupId>com.danrusu.pods4k</groupId>
    <artifactId>pods4k</artifactId>
    <version>latest_version</version>
</dependency>
```

Alternatively, you can [pick & choose](publishing/bom/README.md) individual components of this library.

## Immutable Arrays

[Immutable Arrays](immutable-arrays/README.md) offer a safer, faster, and more efficient alternative to lists while
maintaining familiar syntax.

#### Key Benefits

* ![Fast][fast-shield] [2 to 8 times faster than lists](immutable-arrays/BENCHMARKS.md) for most operations.
* ![Efficient][efficient-shield] [Over 4X memory reduction](immutable-arrays/README.md#-efficiency) in many common
  scenarios.
* ![Immutable][immutable-shield] Cannot be modified, even with casting.
* ![Type Safe][type-safe-shield] Prevents accidental mutation attempts at compile time.
* ![Efficient Builders][efficient-builders-shield] Gather elements more efficiently than mutable lists.

#### Intuitive list-like syntax

```kotlin
val people = immutableArrayOf(dan, jill, bobby)

// Iterate naturally
for (person in people) {
    sendMarketingEmailTo(person)
}
// All the usual operations
val employedPeople = people.filter { it.isEmployed() }
val salaries = employedPeople.map { it.salary }
```

See [Immutable Arrays](immutable-arrays/README.md) for more specifics along with detailed comparisons against regular
arrays, read-only lists, and immutable lists.

## Minimum Requirements

* Kotlin 1.9.25
    * This library is K2 compatible as it's used in other projects that use Kotlin 2.1 etc.
* JDK 11
    * Automated tests are run on JDK LTS releases 11, 17, & 21

## Java Compatibility

Some data structures use techniques which are only supported by the Kotlin compiler. While they can be used in a mixed
Java & Kotlin codebase to store one of these data structures in a Java-defined collection, referencing these data
structures by their class name is only supported within Kotlin files.


[maven-central-badge]: https://img.shields.io/badge/dynamic/json?url=https%3A%2F%2Fraw.githubusercontent.com%2Fdaniel-rusu%2Fpods4k%2Frefs%2Fheads%2Fmain%2Flatest_version.json&query=version&style=for-the-badge&label=maven-central&color=orange

[license-badge]: https://img.shields.io/github/license/daniel-rusu/pods4k?style=for-the-badge

[top-language-badge]: https://img.shields.io/github/languages/top/daniel-rusu/pods4k?style=for-the-badge

[build-status-badge]: https://img.shields.io/github/actions/workflow/status/daniel-rusu/pods4k/ci.yml?style=for-the-badge&label=CI

[stars-badge]: https://img.shields.io/github/stars/daniel-rusu/pods4k?style=for-the-badge


[fast-shield]: https://img.shields.io/badge/Blazing_Fast-blue

[efficient-shield]: https://img.shields.io/badge/Memory_Efficient-blue

[immutable-shield]: https://img.shields.io/badge/True_Immutability-blue

[type-safe-shield]: https://img.shields.io/badge/Type_Safety-blue

[efficient-builders-shield]: https://img.shields.io/badge/Efficient_Builders-blue

[github-stars-shield]: https://img.shields.io/github/stars/daniel-rusu/pods4k?label=Star

[latest-version-shield]: https://img.shields.io/badge/dynamic/json?url=https%3A%2F%2Fraw.githubusercontent.com%2Fdaniel-rusu%2Fpods4k%2Frefs%2Fheads%2Fmain%2Flatest_version.json&query=version&label=Latest%20Version&color=orange


[stars-url]: https://github.com/daniel-rusu/pods4k/stargazers

[maven-central-url]: https://central.sonatype.com/artifact/com.danrusu.pods4k/pods4k

[license-url]: https://github.com/daniel-rusu/pods4k/blob/main/LICENSE