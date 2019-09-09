# Changelog

## Unreleased

- Improve feedback when a CLI arg is missing.

## [1.1.0]

- Significantly more consistent with the output of original cowsay.

    This is especially noticeable with the way backslash (character escape) is interpreted in cowfiles.

    For example superfluous escapes are handled better:

Before:

```
 _____
< Moo >
 -----
   \
    \
       /~\
      |oo )
      _\=/_
     /     \
    //|/.\|\\
   ||  \_/  ||
   || |\ /| ||
    \# \_ _/  \#
      | | |
      | | |
      []|[]
      | | |
     /_]_[_\
```

After:

```
 _____
< Moo >
 -----
   \
    \
       /~\
      |oo )
      _\=/_
     /     \
    //|/.\|\\
   ||  \_/  ||
   || |\ /| ||
    # \_ _/  #
      | | |
      | | |
      []|[]
      | | |
     /_]_[_\
```

- Missing escapes are now handled exactly like the original cowsay (not as well).

    Fix the cowfiles not the cowsay.

Before:

```
 _____
< Moo >
 -----
         \
          \
                    ##        .
              ## ## ##       ==
           ## ## ## ##      ===
       /""""""""""""""""\___/ ===
  ~~~ {~~ ~~~~ ~~~ ~~~~ ~~ ~ /  ===- ~~~
       \______ o          __/
         \    \        __/
          \____\______/
```

After:

```
 _____
< Moo >
 -----
         \
          \
                    ##        .
              ## ## ##       ==
           ## ## ## ##      ===
       /""""""""""""""""___/ ===
  ~~~ {~~ ~~~~ ~~~ ~~~~ ~~ ~ /  ===- ~~~
       ______ o          __/
                     __/
          __________/
```

- `cowsay -list` now behaves like original cowsay in that cows are separated by spaces instead of newlines.

- New minimal JAR `classifier=lib` for use as a java library if the "one jar" is too big.

- Better handling of a wide range of third-party cowfiles.

- Fix license (#18)

- Normalize whitespace like original cowsay (tabs and spaces collapse to a single space):

Before:

```
 __________
<     Awesome >
 ----------
        \   ^__^
         \  (oo)\_______
            (__)\       )\/\
                ||----w |
                ||     ||
```

After:

```
 __________
<  Awesome >
 ----------
        \   ^__^
         \  (oo)\_______
            (__)\       )\/\
                ||----w |
                ||     ||
```

- Separate cowfile bundles into their own cowjars.

- Move "offensive" cowfiles out of the default bundle `cowjar` into `cowjar-off`.

- A working [example application](cowsay-example) showing use with Maven, Ant and Java.

- A lot of tweaks under the hood including: no more git submodules, vastly better unit testing, etc.

## [1.0.4]

- Handle piped input:

```bash
echo Moo! | java -jar cowsay.jar
```

- CLI [wrapper](wrappers) scripts facilitate usage without `java -jar`:

```bash
  cowsay Moo!
  cowsay -f tux Moo!
  cowthink Moo!
  echo Moo! | cowsay
```

## [1.0.3]

- Fix multiline wrapping issues encountered with long messages (#7).

## [1.0.2]

- Handle multiple args passed as message (#4).

## [1.0.1]

- Added HTML output mode.

## [1.0.0]

- Initial release.

[1.1.0]: https://github.com/ricksbrown/cowsay/compare/cowsay-1.0.4...cowsay-parent-1.1.0
[1.0.4]: https://github.com/ricksbrown/cowsay/compare/cowsay-1.0.3...cowsay-1.0.4
[1.0.3]: https://github.com/ricksbrown/cowsay/compare/cowsay-1.0.2...cowsay-1.0.3
[1.0.2]: https://github.com/ricksbrown/cowsay/compare/cowsay-1.0.1...cowsay-1.0.2
[1.0.1]: https://github.com/ricksbrown/cowsay/compare/cowsay-1.0.0...cowsay-1.0.1
[1.0.0]: https://github.com/ricksbrown/cowsay/releases/tag/cowsay-1.0.0
