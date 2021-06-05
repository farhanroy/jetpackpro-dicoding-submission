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
        - memastikan dummy backdrop film sama dengan data backdrop film index ke 0
        - memastikan dummy genre film sama dengan data genre film index ke 0
        - memastikan dummy id film sama dengan data id film index ke 0
        - memastikan dummy nama film sama dengan data nama film index ke 0
        - memastikan dummy deskripsi film sama dengan data deskripsi film index ke 0
        - memastikan dummy runtime film sama dengan data runtime film index ke 0
        - memastikan dummy vote rata 2 film sama dengan data vote rata 2 film index ke 0
        - memastikan dummy tanggal rilis film sama dengan data tanggal rilis film index ke 0

- DetailTvViewModelTest
    - Memuat data tv:
        - memastikan data tv tidak null
        - memastikan dummy backdrop tv sama dengan data backdrop tv index ke 0
        - memastikan dummy genre tv sama dengan data genre tv index ke 0
        - memastikan dummy id tv sama dengan data id tv index ke 0
        - memastikan dummy nama tv sama dengan data nama tv index ke 0
        - memastikan dummy deskripsi tv sama dengan data deskripsi tv index ke 0
        - memastikan dummy runtime tv sama dengan data runtime tv index ke 0
        - memastikan dummy vote rata 2 tv sama dengan data vote rata 2 tv index ke 0
        - memastikan dummy tanggal rilis tv sama dengan data tanggal rilis tv index ke 0


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

















