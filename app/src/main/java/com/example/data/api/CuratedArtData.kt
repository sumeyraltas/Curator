package com.example.data.api

import com.example.data.model.ArtMovement
import com.example.data.model.Artwork
import com.example.data.model.Museum

object CuratedArtData {

    val masterpieceOfTheDay = Artwork(
        id = "starry-night",
        title = "The Starry Night",
        artistName = "Vincent van Gogh",
        creationYear = "1889",
        medium = "Oil on Canvas",
        dimensions = "73.7 cm × 92.1 cm",
        location = "The Museum of Modern Art, New York",
        description = "Painted in June 1889, it depicts the view from the east-facing window of his asylum room at Saint-Rémy-de-Provence, just before sunrise, with the addition of an imaginary village. It has been in the permanent collection of the Museum of Modern Art in New York City since 1941, acquired through the Lillie P. Bliss Bequest.\n\nWidely hailed as Van Gogh's magnum opus, the painting is among the most recognized paintings in the history of Western culture. The night sky depicted by van Gogh in the Starry Night is brimming with whirling clouds, shining stars, and a bright crescent moon. The setting is one that viewers can relate to and van Gogh's swirling sky directs the viewer's eye around the painting, with spacing between the stars and the curving contours creating a dot-to-dot effect.\n\nThe aesthetic evokes a profound sense of isolation yet universal connection, balancing turbulent emotion with technical mastery of post-impressionist color theory and impasto technique.",
        imageUrl = "https://lh3.googleusercontent.com/aida-public/AB6AXuAMiMf18i3Aug2CnQtSxZ06RwqRqQ83uO3_iVNfJ0q6H7LFwIkTZzjz1-2SAqUv99jK-0KwA89QNJILdBTYlWH-2vq0qPyY9S6E3fhaUGHcnf2i2Ho97s1HXojsodMn8_CKFSq6uNr4RWNAdC6-vJoebE9_i7FQqQoRmKyeTkei1WxfXXb-5y0b-R_6fwNZ_Lc4dXL88FxgeT0eOOTvoO2t975-bjOk9tBX_BZMZpRjhiga7Jk3fe5C",
        movement = "Post-Impressionism",
        aiAnalysis = "Key Compositional Dynamics:\n1. Expressive Impasto Brushwork: Thick, energetic paint application creates dynamic rhythmic motion across the celestial plane.\n2. Color Contrast: Deep ultramarine and cobalt blues oppose glowing cadmium yellow and gold accents, establishing emotional tension.\n3. Flame-like Cypress: The vertical cypress tree links the earthly realm with the infinite cosmos, acting as a mournful yet resilient anchor."
    )

    val curatedArtworks = listOf(
        masterpieceOfTheDay,
        Artwork(
            id = "starry-night-rhone",
            title = "Starry Night Over the Rhône",
            artistName = "Vincent van Gogh",
            creationYear = "1888",
            medium = "Oil on Canvas",
            dimensions = "72.5 cm × 92 cm",
            location = "Musée d'Orsay, Paris",
            description = "Painted at the bank of the Rhône River in Arles, this masterpiece captures the nocturnal magic of streetlamps reflecting on shimmering waters beneath a starry night sky. A couple walks in the foreground, imbuing the scene with intimate quietude.",
            imageUrl = "https://lh3.googleusercontent.com/aida-public/AB6AXuAk97-8toKB2ZHsz8LWkDXIcpG14ukbZpRqL5e9D0QqAt7mX2nvD2JoFz444cfPLciylCwwPG-Y64oPGklAcUuSgPhmJ9B5Ad1kt0VASmdtUSFM4Tq-oPyOZexjeX5bfgfD49GPpbCVqTxsZeUAAVYcqV0nSVrVWKp6ooO1KpQZXiBG8YnaInSwntahZ0DMxsI6tmRNw3v-pxVq4uRsHLeKrs9xI1RS_mMZ1QFKefCO2SGpKVlf9rvo",
            movement = "Post-Impressionism"
        ),
        Artwork(
            id = "david-detail",
            title = "David (Detail)",
            artistName = "Michelangelo",
            creationYear = "1504",
            medium = "Carrara Marble",
            dimensions = "5.17 m height",
            location = "Galleria dell'Accademia, Florence",
            description = "A masterpiece of Renaissance sculpture created in marble between 1501 and 1504. David is a 5.17-metre marble statue of the Biblical hero David, a favored subject in the art of Florence. The sculpture exhibits tense anatomical precision, tense gaze, and ideal human proportion.",
            imageUrl = "https://lh3.googleusercontent.com/aida-public/AB6AXuA-ySEbHGoBNlfSIcSlk2IQHnh6Eg0wTY2awqGoxf5np7yQrBQeIqkvOjBot1D5THwXcVSmQfE6Qb4oHih5qmDMh2roN627DxGxSWg3MUR3dHv-2abdqxgiu2FFCkjljCs_zW1GqSuJQgsP7ChIvDdfVTbzmBRl8YwmD-knmOTP1slnqw4BToROfubTYZpfHBo9RLGvyFeW66Qp0kvc7O22vM6OQambGXxL-I1cm1ArPrt8gvFAYYQM",
            movement = "Renaissance"
        ),
        Artwork(
            id = "great-wave",
            title = "The Great Wave off Kanagawa",
            artistName = "Katsushika Hokusai",
            creationYear = "1831",
            medium = "Woodblock Print; Ink and Color on Paper",
            dimensions = "25.7 cm × 37.8 cm",
            location = "Tokyo National Museum / Art Institute of Chicago",
            description = "The Great Wave off Kanagawa is a ukiyo-e woodblock print by the Japanese artist Hokusai. It depicts a towering wave threatening boats off the coast of Sagami Bay, with Mount Fuji visible in the background, framing nature's sublime strength against human vulnerability.",
            imageUrl = "https://lh3.googleusercontent.com/aida-public/AB6AXuBldFqRhbXi3VmVQFjj9VUXoynuWWwGJhIYIT27trKsLUm1KVEynbgmiT-KFOBS2FBgbODqLKEmaRvJzm28kkbqQVy5VTXcT0vBVcrBxqGfZSQlHqeJvz7PlO1AQIMrburyLHnnpP4LAJjw3ovYN-36NuquN0Db3721KevDHwgaR-Ljdyn-kWKssWq68nW9z3I6cFeO6CkApqnqI5X3zjCBHDMBlcX3SRMRzQiZOKXwB1_4LYKcQFSl",
            movement = "Japanese Woodblock"
        ),
        Artwork(
            id = "number-1-lavender-mist",
            title = "Number 1 (Lavender Mist)",
            artistName = "Jackson Pollock",
            creationYear = "1950",
            medium = "Oil, Enamel, and Aluminum Paint on Canvas",
            dimensions = "221 cm × 299.7 cm",
            location = "National Gallery of Art, Washington, D.C.",
            description = "An emblematic piece of Abstract Expressionism created using Pollock's signature drip and pour technique. Web-like layers of black, white, silver, and muted mauve intertwine in an energetic dance of gestural rhythm and tactile depth.",
            imageUrl = "https://lh3.googleusercontent.com/aida-public/AB6AXuD_Ey2xUHgH6gENvTYR6ZYv-PKf7PQLJzHQUIUHDclMgm81Qexv98qATv-RmmpBUugsgzMs_H7o3R_Sy6B-3NyMf25lG_TYY_ZQZZFtx2jahJXtg9e27t1DvFmDmo8VdicZK0Ya-Hu3ZwgxffFUhti6IaWG8fdGtYjYdmijQqkYO600pWI6zNqnApM7t5PI9_uzqsdPm7fa-FTCNVBD_ri799NA2WyS8G9TCRM0rJXEx_mGSvhZm97_",
            movement = "Abstract Expressionism"
        ),
        Artwork(
            id = "cafe-terrace",
            title = "Cafe Terrace at Night",
            artistName = "Vincent van Gogh",
            creationYear = "1888",
            medium = "Oil on Canvas",
            dimensions = "80.7 cm × 65.3 cm",
            location = "Kröller-Müller Museum, Otterlo",
            description = "Painted in Arles, France, in September 1888. The painting features a glowing yellow outdoor cafe terrace set against a deep blue, starry night sky. Van Gogh executed this painting on site without using black, relying entirely on warm and cool contrasting hues.",
            imageUrl = "https://lh3.googleusercontent.com/aida-public/AB6AXuAwa356oUUih_9QjTP7Nf02uFB_wD_eSZjE0UrUnm2hj1Q-cyDNNLaJQATD_yxRmDGzV4-TzeC1zwn8AJpY4Fce2hTcLFB0Z5jzgc_jin2Vjwv9FDYOSoV3ZNyHCWxEoYJRCeZZlHy40Y_SHys9rwrQPyL4ignha5ftzfY_Dh3uB7eopAc2-Y7qXniEoxH8xPE9defxfuy0Cu5uOcVgxZid1ushLpmUHTD4JiwC2oB-QWAYWetgajyD",
            movement = "Post-Impressionism"
        ),
        Artwork(
            id = "sunflowers",
            title = "Sunflowers",
            artistName = "Vincent van Gogh",
            creationYear = "1888",
            medium = "Oil on Canvas",
            dimensions = "92.1 cm × 73 cm",
            location = "National Gallery, London",
            description = "Part of Van Gogh's celebrated Arles series of sunflower still lifes created to decorate Paul Gauguin's bedroom in the Yellow House. Expressing gratitude and life energy through luminous shades of yellow and sculpted impasto.",
            imageUrl = "https://lh3.googleusercontent.com/aida-public/AB6AXuArXrhrF7ENmzqyKEMEqiSFWU9c6VyrFTHL7kFr1ogwKiZHR1GAhlA02nSgUgJE3eyptL2_26TSc4DXa4ChL1Zuy4fpeJcmUScbKnU73lVZdDr6psWGnlMMjFTP-RgfpYfc5eCZxlkxWtENgmPRQw0dbsqhroX_xqgn5mHO2YhPzWEt6QGkTY3er-by9oM2vtVrIxKDJO-OdkizcWtvB7ED6I5msgqPp6MzgWVl1ZucL_tSZM4yUpGS",
            movement = "Post-Impressionism"
        ),
        Artwork(
            id = "self-portrait-vangogh",
            title = "Self-Portrait",
            artistName = "Vincent van Gogh",
            creationYear = "1889",
            medium = "Oil on Canvas",
            dimensions = "65 cm × 54 cm",
            location = "Musée d'Orsay, Paris",
            description = "A striking self-portrait painted shortly before leaving Saint-Rémy. The rhythmic, undulating blue-green background swirls around his intense, introspective visage, capturing profound psychological vulnerability and artistic willpower.",
            imageUrl = "https://lh3.googleusercontent.com/aida-public/AB6AXuBzU3UHkj8so3B1OPqlmEkl1pk_OCBXHvAASY9XAX7fyGwGZK42UmwVyAMtZSB-7sjXvT1oW12zQvfU83hQLXCEM04UH-0SgGj96o8VbztQKIcJJCjvbF2gJwHsK2bSfZIOCYo1UJSFuCvAo-Rcn3hmCOrPZsZmy0W7sM9Fbk8lAoLZ_fKqVZztLTXvKc0g0mnRLJuyiCbKvP8GpExSf4LM-haxgc7TVuwAi50mC_kNO2GMpwNtrC4q",
            movement = "Post-Impressionism"
        )
    )

    val artMovements = listOf(
        ArtMovement(
            id = "renaissance",
            name = "Renaissance",
            era = "14th - 17th Century",
            description = "The rebirth of classical learning and wisdom in Europe, characterized by mathematical perspective, sfumato, realism, and human emotion.",
            imageUrl = "https://lh3.googleusercontent.com/aida-public/AB6AXuCNuZRLtFCO8rxKhCK_i1nk1N1hXvz13Ypxs3L_4EhWCqOUg1j5TPqMzbHZDVY6rJirCAbcu6kx4I8sHvAdstlktJR60hD8xMMXioga-UZGrjViakPcDd_IBQGyvzJTjs1e9hWhttE-YyBK936KvDqCXyRyIAdWh1EzQjqqhLChb2DlDVCrplNOgIm7_iG7o44xmKzUzlTTeuoPPVncrBRcfnRbCwiVKqucP0FjqsMbSKpNzpgYpuS5"
        ),
        ArtMovement(
            id = "impressionism",
            name = "Impressionism",
            era = "19th Century",
            description = "Capturing the momentary, sensory effect of a scene using loose brushwork, vivid unmixed colors, and natural outdoor light.",
            imageUrl = "https://lh3.googleusercontent.com/aida-public/AB6AXuDnNSrru-Xfcc2DdlA95jpW6ihEwm9_zeStXeGsjhITggz6gugQPDzMIibszTdRHsYLtvuGpuHcNfP9DIPJ65YJwO4zyd2pUWSzrSgP561Ey-G6bEwdi4ECuhp-RCtjcZQIUp-q54wq6rXVjx3lCGfmc1m8S0mTAOfpAxUcdv09QGq57uYK8vlLpE0rwqwW39oqlep0ClJWd1olCvKFSFWNghUL3Y_oc2ueOgyFpYHrXcxlHsLjWx5R"
        ),
        ArtMovement(
            id = "surrealism",
            name = "Surrealism",
            era = "20th Century",
            description = "Exploring the unconscious mind through dreamlike imagery, automatic drawing, and startling juxtapositions.",
            imageUrl = "https://lh3.googleusercontent.com/aida-public/AB6AXuBrh_CVny10L3r7eBb9-NgtH0qJQEArH7wr1rfBYKetoxk8WX4VB6NU53mkhTqyEOaxKFBV4pVyecPheokRA23wanLNp53kNZc9LIU5S8sipF3_PPlKyaNK4Anvd_9cTaAvEMC03Gf4a1PXJHdoV57ZOQPClLEI6dOQSUuXuVqsxxQ4eZwdutI-RHPkiVn8uao5x5wCQcuU_E_sfm2jTh3av6P57ps517jGs2AaKuL6t7jAl0zmHVoW"
        )
    )

    val museums = listOf(
        Museum(
            id = "louvre",
            name = "The Louvre",
            city = "Paris",
            country = "France",
            imageUrl = "https://lh3.googleusercontent.com/aida-public/AB6AXuAbME-svuRA6C2hHUmYdcJq4mx5dk5oy-5_gHW05tMP2MxZkKkN8e4IqpuM2_rCZ61Q_F9WJ6pIms7FoW-gO3QDWtcx7kZFnLd7RZnmG6-d7K1TgZhYURO14ZoYMsMRMRkp0Ceb0Fz3653HK1oiP5g6hoUEbkWR77XDm3kHW1U1RLPSwdQgzMRj5XBOnpGGPaiXB5wHWmkiXZnhKoizAXZcOeoecBXqMkJgixjEOOHvWT-_E3TQlBmt",
            artworkCount = 38000
        ),
        Museum(
            id = "moma",
            name = "MoMA",
            city = "New York",
            country = "USA",
            imageUrl = "https://lh3.googleusercontent.com/aida-public/AB6AXuBWxz1VV-1OI-uk56_9g65FxjABrXGllbEKYsBcwKtRRhhilccJH_ViTYS0TLKFMlwzt0UUocmECi06jFs5rT_kE_mMfnFCuG5qG2B0Y2mDL1634NcMxrJygEWokG4r4lJVxYudq3Kcw22dlOHhCQF--wQJYsJ_a8R08acitqxQdhxgMWBXA675EQ5Jy4ZTV5-xMhGG2kAHzoR_eyN8vABNtnSpGloUAygs-P_XJQJ99haGkUSKWTFr",
            artworkCount = 200000
        ),
        Museum(
            id = "prado",
            name = "Prado Museum",
            city = "Madrid",
            country = "Spain",
            imageUrl = "https://lh3.googleusercontent.com/aida-public/AB6AXuBGID6ApDZwl0Mswm3Fbf-cV9U3ovAm2xFQmPO4ulWKPuoYA2TPMzueYRJuuNE8WTrmaMaeNhIynp4n-TAlgBrQncS-JRcQ2bsp-QtZvbyxAfwl_bGz0v9smhJgOOe9r86HydZG8JlAxOpneRAG2FY7-xUIHDuuMIbjA7rSE70dELAtfpDZVRhlZm3Bg2c-B8zcMykPcD4-OlN2Wyhbl0IBhVKGXwywIAt1lAj1Lc7K0sFpIgHHEXjl",
            artworkCount = 27000
        )
    )
}
