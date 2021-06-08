## Test Scenario
- TrendingMovieViewModelTest
    - Memuat data film:
        - memastikan data film tidak null
        - memastikan jumlah data film sesuai ekspetasi yaitu 3

- TvShowViewModelTest
    - Memuat data tv:
        - memastikan data tv tidak null
        - memastikan jumlah data tv sesuai ekspetasi yaitu 3

- DetailMovieViewModelTest
    - Memuat data film:
        - memastikan data film tidak null
        - memastikan observe film bekerja dengan baik
        - memastikan data setFavorite bernilai true

- DetailTvViewModelTest
    - Memuat data tv:
        - memastikan data TV tidak null
        - memastikan observe TV bekerja dengan baik
        - memastikan data setFavorite bernilai true


- MovieFavoriteViewModelTest
    - Set Favorite: Memastikan data setFavorite bernilai true
    - Get Favorite: Memastikan data favorite bernilai 3 dan tidak null

- MovieFavoriteViewModelTest
    - Set Favorite: Memastikan data setFavorite bernilai true
    - Get Favorite: Memastikan data favorite bernilai 3 dan tidak null


Intrumented Test
- HomeActivityTest
    - Memuat list movie:
        - cek apakah recycler view dari list movie tampil
        - mencoba menggulirkan recycler view ke index terakhir

    - Memuat list tvShow
        - cek apakah recycler view dari list tvShow tampil
        - mencoba menggulirkan recycler view ke index terakhir

    - Memuat detail movie
        - klik pada item index ke 0 pada list movie (untuk menuju ke halaman detail)
        - mengecek apakah poster image view tampil
        - scrolling coordinator layout
        - cek apakah backdrop image tampil
        - cek apakah view collapsing tampil
        - cek textview overview movie apakah tampil

    - Memuat detail tvShow
            - klik pada item index ke 0 pada list tvShow (untuk menuju ke halaman detail)
            - mengecek apakah poster image view tampil
            - scrolling coordinator layout
            - cek apakah backdrop image tampil
            - cek apakah view collapsing tampil
            - cek textview overview tvShow apakah tampil

    - Memuat list favorite movie
            - perform click pada bottom nav dengan id movieFavoriteFragment
            - cek apakah recycler view dari list movie tampil
            - mencoba menggulirkan recycler view ke index terakhir

    - Memuat list favorite tvShow
            - perform click pada bottom nav dengan id tvShowFavoriteFragment
            - cek apakah recycler view dari list tvShow tampil
            - mencoba menggulirkan recycler view ke index terakhir

    - Memuat detail movie favorite
            - cek apakah recycler view dari list movie tampil
            - klik pada index 0
            - tekan floating action button untuk menambahkan favorite
            - tekan kembali / press back
            - perform click pada bottom nav dengan id favoriteFragment
            - klik list pada index 0
            - mengecek apakah poster image view tampil
            - tekan floating action button untuk menghapus favorite
            - scrolling coordinator layout
            - cek apakah backdrop image tampil
            - cek apakah view collapsing tampil
            - cek textview overview movie apakah tampil

    - Memuat detail tvShow favorite
                - cek apakah recycler view dari list tvShow tampil
                - klik pada index 0
                - tekan floating action button untuk menambahkan favorite
                - tekan kembali / press back
                - perform click pada bottom nav dengan id favoriteFragment
                - klik list pada index 0
                - mengecek apakah poster image view tampil
                - tekan floating action button untuk menghapus favorite
                - scrolling coordinator layout
                - cek apakah backdrop image tampil
                - cek apakah view collapsing tampil
                - cek textview overview movie apakah tampil

















