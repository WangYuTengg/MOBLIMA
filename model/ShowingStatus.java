package model;

/**
 * an ENUM for ShowingStatus
 * @version  1.0
 * @author   Guo Sihan, Davyn Yam JunHao, Wang Yu Teng, Aditya Pugalia, Ng Yong Jian
 * @since    2022-10-30
 */
public enum ShowingStatus {
    /**
     * To show that a movie is yet to be shown.
     */
    COMING_SOON,

    /**
     * To show that a movie is currently only being previewed in Cinemas.
     */
    PREVIEW,

    /**
     * To show that a movie is currently being shown in Cinemas.
     */
    NOW_SHOWING,

    /**
     * To show that the movie is no longer showing in Cinemas.
     */
    END_OF_SHOWING
}
