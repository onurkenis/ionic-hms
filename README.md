# Ionic - HMS Sample

This simple repo integrates HMS Cordova Push Plugin and has Capacitor custom plugin examples for Analytics & Push Kit of HMS ecosystem.

## Running the application

1. Install dependencies

```sh
cd ionic-hms
npm install
```

2. Build Ionic app with the following command

```sh
ionic build
```
3. Copy web assets to your project

```sh
npx cap copy
```

4. Build and run the Ionic App using Android Studio

```sh
npx cap open android
```
If you are having issues, you can follow [getting started.](https://capacitor.ionicframework.com/docs/android/)


## Contributing

Commit messages must comply with [conventional commits](https://www.conventionalcommits.org). Otherwise [commitlint](https://github.com/conventional-changelog/commitlint) will complain.

Thanks to [commitizen](https://github.com/commitizen), `npm run commit` command can be used to create commit messages complying with conventional commits.
