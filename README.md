# CleanVideoPlayer

CleanVideoPlayer is a simple app based on clean architecture + MVVM. It contains three main modules (Data, Domain, Presentation), and this repo tried to give a clear understanding of the clean architecture.

Currently, the app has only two fragments. The first one shows a list of videos, and the second fragment fetches video details from the server.

### Project flow

<p align="center">
  <img src=images/project_arc.png>
</p>

One thing that is not mentions in the image is that we call domain-layer-models `Entity` and data-layer-models `Model`, and these two layers communicate with each other using mappers defined in the data layer.

### Used technologies and tools
- Clean architecture
- MVVM pattern
- Hilt
- Coroutines
- ExoPlayer
- Navigation component
- Retrofit
- Moshi

The fake server provides by [typicode](https://my-json-server.typicode.com/).

---

Feel free to submit any issue and all comments are welcome.

Contact: [Telegram](https://t.me/ThisIsSadeghi), [Email](mailto:alisadeghi.dev@gmail.com) & [Twitter](https://twitter.com/ThisIsSadeghi).
