package github.learn.movie.utils

import github.learn.movie.data.source.local.entity.DetailEntity
import github.learn.movie.data.source.local.entity.MovieEntity
import github.learn.movie.data.source.local.entity.TvShowEntity
import github.learn.movie.data.source.remote.response.movie.*
import github.learn.movie.data.source.remote.response.movie.Genre
import github.learn.movie.data.source.remote.response.movie.ProductionCompany
import github.learn.movie.data.source.remote.response.movie.ProductionCountry
import github.learn.movie.data.source.remote.response.movie.SpokenLanguage
import github.learn.movie.data.source.remote.response.tv.*

typealias TvShowGenre = github.learn.movie.data.source.remote.response.tv.Genre
typealias TvShowProductionCompany = github.learn.movie.data.source.remote.response.tv.ProductionCompany
typealias TvShowProductionCountry = github.learn.movie.data.source.remote.response.tv.ProductionCountry
typealias TvShowSpokenLanguage = github.learn.movie.data.source.remote.response.tv.SpokenLanguage

object DataDummy {
    fun getMovies(): List<MovieEntity> {
        return listOf(
            MovieEntity(
                691179,
                "Friends: The Reunion",
                "/bT3c4TSOP8vBmMoXZRDPTII6eDa.jpg",
                8.3
            ),
            MovieEntity(
                637649,
                "Wrath of Man",
                "/YxopfHpsCV1oF8CZaL4M3Eodqa.jpg",
                7.9
            ),
            MovieEntity(
                503736,
                "Army of the Dead",
                "/z8CExJekGrEThbpMXAmCFvvgoJR.jpg",
                6.7
            )
        )
    }

    fun getDetailMovie(): DetailEntity {
        return DetailEntity(
            "/sF19W36JtRIhAm3VciggSkzBtt.jpg",
            listOf("Comedy", "Documentary", "TV Movie"),
            691179,
            "The cast of Friends reunites for a once-in-a-lifetime celebration of the hit series, an unforgettable evening filled with iconic memories, uncontrollable laughter, happy tears, and special guests.",
            "/bT3c4TSOP8vBmMoXZRDPTII6eDa.jpg",
            "2021-05-27",
            104,
            "Friends: The Reunion",
            8.3
        )
    }

    fun getTvShows(): List<TvShowEntity> {
        return listOf(
            TvShowEntity(
                id = 60735,
                name = "The Flash",
                posterPath = "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                voteAverage = 7.7
            ),
            TvShowEntity(
                id = 120168,
                name = "Who Killed Sara?",
                posterPath = "/o7uk5ChRt3quPIv8PcvPfzyXdMw.jpg",
                voteAverage = 7.8
            ),
            TvShowEntity(
                id = 71712,
                name = "The Good Doctor",
                posterPath = "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                voteAverage = 8.6
            )
        )
    }

    fun getDetailTvShow(): DetailEntity {
        return DetailEntity(
            "/9Jmd1OumCjaXDkpllbSGi2EpJvl.jpg",
            listOf("Drama", "Sci-Fi & Fantasy"),
            60735,
            "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
            "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
            "2014-10-07",
            44,
            "The Flash",
            7.7
        )
    }

    // for remote
    fun getRemoteMovies(): List<Movie> {
        return listOf(
            Movie(
                adult = false,
                backdropPath = "/sF19W36JtRIhAm3VciggSkzBtt.jpg",
                genreIds = listOf(35, 99, 10770),
                id = 691179,
                originalLanguage = "en",
                originalTitle = "Friends: The Reunion",
                overview = "The cast of Friends reunites for a once-in-a-lifetime celebration of the hit series, an unforgettable evening filled with iconic memories, uncontrollable laughter, happy tears, and special guests.",
                popularity = 155.168,
                posterPath = "/bT3c4TSOP8vBmMoXZRDPTII6eDa.jpg",
                releaseDate = "2021-05-27",
                title = "Friends: The Reunion",
                video = false,
                voteAverage = 8.3,
                voteCount = 64
            ),
            Movie(
                adult = false,
                backdropPath = "/70AV2Xx5FQYj20labp0EGdbjI6E.jpg",
                genreIds = listOf(28, 30),
                id = 637649,
                originalLanguage = "en",
                originalTitle = "Wrath of Man",
                overview = "A cold and mysterious new security guard for a Los Angeles cash truck company surprises his co-workers when he unleashes precision skills during a heist. The crew is left wondering who he is and where he came from. Soon, the marksman's ultimate motive becomes clear as he takes dramatic and irrevocable steps to settle a score.",
                popularity = 459.024,
                posterPath = "/YxopfHpsCV1oF8CZaL4M3Eodqa.jpg",
                releaseDate = "2021-04-22",
                title = "Wrath of Man",
                video = false,
                voteAverage = 7.9,
                voteCount = 257
            ),
            Movie(
                adult = false,
                backdropPath = "/c0izdYdnTe4uMRifHgvTA85wPz0.jpg",
                genreIds = listOf(28, 27, 53),
                id = 503736,
                originalLanguage = "en",
                originalTitle = "Army of the Dead",
                overview = "Following a zombie outbreak in Las Vegas, a group of mercenaries take the ultimate gamble: venturing into the quarantine zone to pull off the greatest heist ever attempted.",
                popularity = 2362.737,
                posterPath = "/z8CExJekGrEThbpMXAmCFvvgoJR.jpg",
                releaseDate = "2021-05-14",
                title = "Army of the Dead",
                video = false,
                voteAverage = 6.7,
                voteCount = 960
            )
        )
    }

    fun getRemoteDetailMovie(): MovieDetailResponse {
        return MovieDetailResponse(
            adult = false,
            backdropPath = "/sF19W36JtRIhAm3VciggSkzBtt.jpg",
            belongsToCollection = null,
            budget = 0,
            genres = listOf(
                Genre(
                    id = 35,
                    name = "Comedy"
                ),
                Genre(
                    id = 99,
                    name = "Documentary"
                ),
                Genre(
                    id = 10770,
                    name = "TV Movie"
                )
            ),
            homepage = "https://play.hbomax.com/page/urn:hbo:page:GYJxCDACcN8PDewEAAAAG:type:feature",
            id = 691179,
            imdbId = "tt11337862",
            originalLanguage = "en",
            originalTitle = "Friends: The Reunion",
            overview = "The cast of Friends reunites for a once-in-a-lifetime celebration of the hit series, an unforgettable evening filled with iconic memories, uncontrollable laughter, happy tears, and special guests.",
            popularity = 110.834,
            posterPath = "/l00ff9dmop1UBfb4QNrLMQl5fgc.jpg",
            productionCompanies = listOf(
                ProductionCompany(
                    id = 1957,
                    logoPath = "/3T19XSr6yqaLNK8uJWFImPgRax0.png",
                    name = "Warner Bros. Television",
                    originCountry = "US"
                ),
                ProductionCompany(
                    id = 31810,
                    logoPath = null,
                    name = "Bright/Kauffman/Crane Productions",
                    originCountry = "US"
                )
            ),
            productionCountries = listOf(
                ProductionCountry(
                    iso31661 = "US",
                    name = "United States of America"
                )
            ),
            releaseDate = "2021-05-27",
            revenue = 0,
            runtime = 104,
            spokenLanguages = listOf(
                SpokenLanguage(
                    englishName = "English",
                    iso6391 = "en",
                    name = "English"
                )
            ),
            status = "Released",
            tagline = "The One Where They Get Back Together.",
            title = "Friends: The Reunion",
            video = false,
            voteAverage = 8.3,
            voteCount = 59

        )
    }

    fun getRemoteTvShows(): List<TvShow> {
        return listOf(
            TvShow(
                backdropPath = "/9Jmd1OumCjaXDkpllbSGi2EpJvl.jpg",
                firstAirDate = "2014-10-07",
                genreIds = listOf(18, 10765),
                id = 60735,
                name = "The Flash",
                originCountry = listOf("US"),
                originalLanguage = "en",
                originalName = "The Flash",
                overview = "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                popularity = 1254.269,
                posterPath = "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                voteAverage = 7.7,
                voteCount = 7694
            ),
            TvShow(
                backdropPath = "/dYvIUzdh6TUv4IFRq8UBkX7bNNu.jpg",
                firstAirDate = "2021-03-24",
                genreIds = listOf(18, 80, 9648),
                id = 120168,
                name = "Who Killed Sara?",
                originCountry = listOf("MX"),
                originalLanguage = "es",
                originalName = "¿Quién mató a Sara?",
                overview = "Hell-bent on exacting revenge and proving he was framed for his sister's murder, Álex sets out to unearth much more than the crime's real culprit.",
                popularity = 1025.991,
                posterPath = "/o7uk5ChRt3quPIv8PcvPfzyXdMw.jpg",
                voteAverage = 7.8,
                voteCount = 723
            ),
            TvShow(
                backdropPath = "/iDbIEpCM9nhoayUDTwqFL1iVwzb.jpg",
                firstAirDate = "2017-09-25",
                genreIds = listOf(18),
                id = 71712,
                name = "The Good Doctor",
                originCountry = listOf("US"),
                originalLanguage = "en",
                originalName = "The Good Doctor",
                overview = "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                popularity = 1017.303,
                posterPath = "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                voteAverage = 8.6,
                voteCount = 8489
            )
        )
    }

    fun getRemoteDetailTvShow(): TvShowDetailResponse {
        return TvShowDetailResponse(
            backdropPath = "/9Jmd1OumCjaXDkpllbSGi2EpJvl.jpg",
            createdBy = listOf(
                CreatedBy(
                    id = 88967,
                    creditId = "5bd5a46d0e0a2622bd02be75",
                    name = "Greg Berlanti",
                    gender = 2,
                    profilePath = "/1T24SiIIDMa9gAmq7QaYwZywq4y.jpg"
                ),
                CreatedBy(
                    id = 211962,
                    creditId = "537523f9c3a3681ef4000177",
                    name = "Geoff Johns",
                    gender = 2,
                    profilePath = "/1hiQjkIkeFoiwvD4yIk2Dq6tnOa.jpg"
                ),
                CreatedBy(
                    id = 1216615,
                    creditId = "5bd5a45ec3a36820f002e57f",
                    name = "Andrew Kreisberg",
                    gender = 2,
                    profilePath = null
                )
            ),
            episodeRunTime = listOf(44),
            firstAirDate = "2014-10-07",
            genres = listOf(
                TvShowGenre(
                    id = 18,
                    name = "Drama"
                ),
                TvShowGenre(
                    id = 10765,
                    name = "Sci-Fi & Fantasy"
                )
            ),
            homepage = "http://www.cwtv.com/shows/the-flash/",
            id = 60735,
            inProduction = true,
            languages = listOf("en"),
            lastAirDate = "2021-01-01",
            lastEpisodeToAir = LastEpisodeToAir(
                airDate = "2021-05-25",
                episodeNumber = 11,
                id = 2935399,
                name = "Family Matters, Pt. 2",
                overview = "Barry and Iris come together to try and stop a dangerous force from destroying Central City.",
                productionCode = "T27.14161",
                seasonNumber = 7,
                stillPath = "/jVeI2K7CJ3lO76VP9xIzAJQcvgT.jpg",
                voteAverage = 7.0,
                voteCount = 1
            ),
            name = "The Flash",
            nextEpisodeToAir = NextEpisodeToAir(
                airDate = "2021-06-08",
                episodeNumber = 12,
                id = 2935400,
                name = "Good-Bye Vibrations",
                overview = "Cisco and Kamilla tell the team they are leaving Central City. However, Barry, Iris and Caitlin don't have much time to digest the news because a new version of Rainbow Raider strikes and OG Team Flash must join together one final time to save the city.",
                productionCode = "",
                seasonNumber = 7,
                stillPath = null,
                voteAverage = 0.0,
                voteCount = 0
            ),
            networks = listOf(
                Network(
                    name = "The CW",
                    id = 71,
                    logoPath = "/ge9hzeaU7nMtQ4PjkFlc68dGAJ9.png",
                    originCountry = "US"
                )
            ),
            numberOfEpisodes = 146,
            numberOfSeasons = 7,
            originCountry = listOf("US"),
            originalLanguage = "en",
            originalName = "The Flash",
            overview = "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
            popularity = 1254.269,
            posterPath = "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
            productionCompanies = listOf(
                TvShowProductionCompany(
                    id = 1957,
                    logoPath = "/3T19XSr6yqaLNK8uJWFImPgRax0.jpg",
                    name = "Warner Bros. Television",
                    originCountry = "US"
                ),
                TvShowProductionCompany(
                    id = 27711,
                    logoPath = "/3e294jszfE6cE8TOogmj0zNd6pL.png",
                    name = "Berlanti Productions",
                    originCountry = "US"
                ),
                TvShowProductionCompany(
                    id = 9993,
                    logoPath = "/2Tc1P3Ac8M479naPp1kYT3izLS5.png",
                    name = "DC Entertainment",
                    originCountry = "US"
                ),
                TvShowProductionCompany(
                    id = 105514,
                    logoPath = "/xuziaSHpTZ2YPT35N8r5PT7jiqL.png",
                    name = "Mad Ghost Productions",
                    originCountry = "US"
                )
            ),
            productionCountries = listOf(
                TvShowProductionCountry(
                    iso31661 = "US",
                    name = "United States of America"
                )
            ),
            seasons = listOf(
                Season(
                    airDate = "2016-04-19",
                    episodeCount = 8,
                    id = 79954,
                    name = "Specials",
                    overview = "",
                    posterPath = "/ft8pUr3qX41kOux5eqrwf02yAxZ.jpg",
                    seasonNumber = 0
                ),
                Season(
                    airDate = "2014-10-07",
                    episodeCount = 23,
                    id = 60523,
                    name = "Season 1",
                    overview = "When an unexpected accident at the S.T.A.R. Labs Particle Accelerator facility strikes Barry, he finds himself suddenly charged with the incredible power to move at super speeds. While Barry has always been a hero in his soul, his newfound powers have finally given him the ability to act like one. With the help of the research team at S.T.A.R. Labs, Barry begins testing the limits of his evolving powers and using them to stop crime. With a winning personality and a smile on his face, Barry Allen — aka The Flash — is finally moving forward in life … very, very fast!",
                    posterPath = "/A3H6pewHfoy2bXmNhvycOe0xzlC.jpg",
                    seasonNumber = 1
                ),
                Season(
                    airDate = "2015-10-06",
                    episodeCount = 23,
                    id = 66922,
                    name = "Season 2",
                    overview = "Following the dramatic events of season 1, Team Flash quickly turns their attention to a threat high above Central City. Armed with the heart of a hero and the ability to move at super speeds, will Barry be able to save his city from impending doom?",
                    posterPath = "/8xWZPVX1cv9V5YD1RPeLj9QZDE9.jpg",
                    seasonNumber = 2
                ),
                Season(
                    airDate = "2015-10-06",
                    episodeCount = 23,
                    id = 66922,
                    name = "Season 2",
                    overview = "Following the dramatic events of season 1, Team Flash quickly turns their attention to a threat high above Central City. Armed with the heart of a hero and the ability to move at super speeds, will Barry be able to save his city from impending doom?",
                    posterPath = "/8xWZPVX1cv9V5YD1RPeLj9QZDE9.jpg",
                    seasonNumber = 2
                ),
                Season(
                    airDate = "2016-10-04",
                    episodeCount = 23,
                    id = 77888,
                    name = "Season 3",
                    overview = "Forensic scientist Barry Allen, aka The Flash, is living his dream life. His parents are alive. He's dating beautiful, smart Iris West. And he's able to stand back and let the new speedster in town, Kid Flash, step in to protect Central City. But the better Barry's life gets, the more dangerous it becomes. His nemesis, Reverse Flash, warns Barry of serious repercussions if he remains in the alternate Flashpoint universe: In addition to memory loss, his powers will fade. When disaster strikes, Barry must decide whether to continue life as Barry Allen or return to his universe as The Flash. As Barry deals with his identity crisis, he and the S.T.A.R. Labs team fight off lethal threats from the God of Speed, Savitar.",
                    posterPath = "/rN1hgV8Ag3bZmkv33Udm93hIxQp.jpg",
                    seasonNumber = 3
                ),
                Season(
                    airDate = "2017-10-10",
                    episodeCount = 23,
                    id = 90247,
                    name = "Season 4",
                    overview = "The mission of Barry Allen, aka The Flash, is once more to protect Central City from metahuman threats. But with Barry trapped in the Speed Force, this mission falls to his family – Detective Joe West; fiancée Iris West; and Wally West/Kid Flash – and the team at S.T.A.R. Labs: Caitlin Snow/Killer Frost, Cisco Ramon/Vibe and brilliant scientist Harrison Wells. When a powerful villain threatens to level the city unless The Flash appears, Cisco risks everything to free Barry. But this is only the first move in a deadly game with Clifford DeVoe, aka The Thinker, a mastermind who’s always ten steps ahead of Barry, no matter how fast Barry runs.",
                    posterPath = "/e6A65vhYFLqgSsMI294ZQi0rQfH.jpg",
                    seasonNumber = 4
                ),
                Season(
                    airDate = "2018-10-09",
                    episodeCount = 22,
                    id = 104777,
                    name = "Season 5",
                    overview = "Barry Allen and his new wife, Iris West, finally settling into married life when they're visited by Nora West-Allen, their speedster daughter from the future. Nora's arrival brings to light the legacy every member of Team Flash will leave years from now, causing many to question who they are today. And while Nora idolizes Barry, she holds a mysterious grudge against Iris. As Team Flash adjusts to the next generation of speedster, they discover Nora's presence has triggered the arrival of the most ruthless, vicious and relentless villain they have ever faced: Cicada!",
                    posterPath = "/ikRkYXHCbwUAQF7vN3GplEDK5VQ.jpg",
                    seasonNumber = 5
                ),
                Season(
                    airDate = "2019-10-08",
                    episodeCount = 19,
                    id = 126171,
                    name = "Season 6",
                    overview = "When Barry and Iris deal with loss of their daughter, the team faces their greatest threat yet - one that threatens to destroy all of Central City; Killer Frost has a brush with death that will change her relationship with Caitlin. Faced with the news of his impending death, Barry's resiliency suffers as he struggles to fight fate.",
                    posterPath = "/syIGmogs3VZuMnTGkVe28I6nZy4.jpg",
                    seasonNumber = 6
                ),
                Season(
                    airDate = "2021-03-02",
                    episodeCount = 13,
                    id = 159996,
                    name = "Season 7",
                    overview = "After a thrilling cliffhanger last season which saw Mirror Monarch victorious and still-at-large in Central City, The Flash must regroup in order to stop her and find a way to make contact with his missing wife, Iris West-Allen. With help from the rest of Team Flash, Barry will ultimately defeat Mirror Master. But in doing so, he’ll also unleash an even more powerful and devastating threat on Central City: one that threatens to tear his team—and his marriage—apart.",
                    posterPath = "/lWCnXD5bMGUtX0J3U97XSVViUud.jpg",
                    seasonNumber = 7
                )

            ),
            spokenLanguages = listOf(
                TvShowSpokenLanguage(
                    englishName = "English",
                    iso6391 = "en",
                    name = "English"
                )
            ),
            status = "Returning Series",
            tagline = "The fastest man alive.",
            type = "Scripted",
            voteAverage = 7.7,
            voteCount = 7696
        )
    }
}