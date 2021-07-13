---
id: basic-options
title: Setting Basic Options
sidebar_label: Basic Options
---

Sauce Bindings are designed to enforce compatibility with the [W3C WebDriver Standard](https://www.w3.org/TR/webdriver/).
 The three that matter most to Sauce Labs users are: 
* `browserName`
* `browserVersion`
* `platformName`

To see what values are supported by Sauce Labs for these capabilities, take a look at our
[Platform Configurator](https://saucelabs.com/platform/platform-configurator#/)

Here's an example of running a test on Firefox and Windows 8.0.

import Tabs from '@theme/Tabs';
import TabItem from '@theme/TabItem';

<Tabs
defaultValue="java"
values={[
{ label: 'Java', value: 'java', },
{ label: 'Python', value: 'python', },
{ label: 'Ruby', value: 'ruby', },
{ label: 'C#', value: 'csharp', },
]
}>

<TabItem value="java">

You can either use Sauce Bindings directly or with the JUnit 4 or TestNG packages

<Tabs
defaultValue="direct"
values={[
{ label: 'Direct', value: 'direct', },
{ label: 'JUnit', value: 'junit', },
{ label: 'TestNG', value: 'testng', },
]
}>

<TabItem value="direct">

```java reference
https://github.com/titusfortner/sauce_bindings/blob/ca7011b4/java/main/src/test/java/com/saucelabs/saucebindings/examples/BasicOptionsTest.java
```

</TabItem>
<TabItem value="junit">

```java reference
https://github.com/titusfortner/sauce_bindings/blob/ca7011b4/java/junit4/src/test/java/com/saucelabs/saucebindings/junit4/examples/BasicOptionsTest.java
```

</TabItem>
<TabItem value="testng">

```java reference
https://github.com/titusfortner/sauce_bindings/blob/ca7011b4/java/testng/src/test/java/com/saucelabs/saucebindings/testng/examples/BasicOptionsTest.java
```

</TabItem>
</Tabs>


</TabItem>
<TabItem value="python">

```python reference
https://github.com/titusfortner/sauce_bindings/blob/ca7011b4/python/tests/examples/test_basic_options.py
```

</TabItem>
<TabItem value="ruby">

```ruby reference
https://github.com/titusfortner/sauce_bindings/blob/ca7011b4/ruby/spec/examples/basic_options_spec.rb
```

</TabItem>
<TabItem value="csharp">

**C# bindings are coming soon...**

</TabItem>
</Tabs>
