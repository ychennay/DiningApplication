package main.java.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by ychen4 on 4/30/2017.
 */

@DynamoDBTable(tableName = "restaurant")
public class Restaurant {

    private String restaurantId;
    private Set<String> address;
    private String city;
    private String countryCode;
    private Set<String> displayAddress;
    private String displayPhone;
    private int geoAccuracy;
    private String id;
    private String imageUrl;
    private String isClaimed;
    private String isClosed;
    private float latitude;
    private float longitude;
    private String mobileUrl;
    private String name;
    private String phone;
    private String postalCode;
    private float rating;
    private String ratingImgUrl;
    private String ratingImgUrlLarge;
    private String ratingImgUrlSmall;
    private int reviewCount;
    private String snippetImgUrl;
    private String snippetText;
    private String stateCode;
    private String url;
    private String userRating;
    private String userBookmark;
    private String userComment;
    private List<Map<String, String>> allComments;
    private String averageRating;

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantId='" + restaurantId + '\'' +
                ", address=" + address +
                ", city='" + city + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", displayAddress=" + displayAddress +
                ", displayPhone='" + displayPhone + '\'' +
                ", geoAccuracy=" + geoAccuracy +
                ", id='" + id + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", isClaimed='" + isClaimed + '\'' +
                ", isClosed='" + isClosed + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", mobileUrl='" + mobileUrl + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", rating=" + rating +
                ", ratingImgUrl='" + ratingImgUrl + '\'' +
                ", ratingImgUrlLarge='" + ratingImgUrlLarge + '\'' +
                ", ratingImgUrlSmall='" + ratingImgUrlSmall + '\'' +
                ", reviewCount=" + reviewCount +
                ", snippetImgUrl='" + snippetImgUrl + '\'' +
                ", snippetText='" + snippetText + '\'' +
                ", stateCode='" + stateCode + '\'' +
                ", url='" + url + '\'' +
                ", userRating='" + userRating + '\'' +
                ", userBookmark='" + userBookmark + '\'' +
                ", userComment='" + userComment + '\'' +
                ", allComments=" + allComments +
                ", averageRating='" + averageRating + '\'' +
                '}';
    }

    public Restaurant(){}

    public Restaurant(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Set<String> getAddress() {
        return address;
    }

    public void setAddress(Set<String> address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Set<String> getDisplayAddress() {
        return displayAddress;
    }

    public void setDisplayAddress(Set<String> displayAddress) {
        this.displayAddress = displayAddress;
    }

    public String getDisplayPhone() {
        return displayPhone;
    }

    public void setDisplayPhone(String displayPhone) {
        this.displayPhone = displayPhone;
    }

    public int getGeoAccuracy() {
        return geoAccuracy;
    }

    public void setGeoAccuracy(int geoAccuracy) {
        this.geoAccuracy = geoAccuracy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getIsClaimed() {
        return isClaimed;
    }

    public void setIsClaimed(String isClaimed) {
        this.isClaimed = isClaimed;
    }

    public String getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(String isClosed) {
        this.isClosed = isClosed;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public String getMobileUrl() {
        return mobileUrl;
    }

    public void setMobileUrl(String mobileUrl) {
        this.mobileUrl = mobileUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getRatingImgUrl() {
        return ratingImgUrl;
    }

    public void setRatingImgUrl(String ratingImgUrl) {
        this.ratingImgUrl = ratingImgUrl;
    }

    public String getRatingImgUrlLarge() {
        return ratingImgUrlLarge;
    }

    public void setRatingImgUrlLarge(String ratingImgUrlLarge) {
        this.ratingImgUrlLarge = ratingImgUrlLarge;
    }

    public String getRatingImgUrlSmall() {
        return ratingImgUrlSmall;
    }

    public void setRatingImgUrlSmall(String ratingImgUrlSmall) {
        this.ratingImgUrlSmall = ratingImgUrlSmall;
    }

    public String getSnippetImgUrl() {
        return snippetImgUrl;
    }

    public void setSnippetImgUrl(String snippetImgUrl) {
        this.snippetImgUrl = snippetImgUrl;
    }

    public String getSnippetText() {
        return snippetText;
    }

    public void setSnippetText(String snippetText) {
        this.snippetText = snippetText;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }

    public String getUserBookmark() {
        return userBookmark;
    }

    public void setUserBookmark(String userBookmark) {
        this.userBookmark = userBookmark;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

    public List<Map<String, String>> getAllComments() {
        return allComments;
    }

    public void setAllComments(List<Map<String, String>> allComments) {
        this.allComments = allComments;
    }

    public String getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(String averageRating) {
        this.averageRating = averageRating;
    }

//    public void setAllComments(String allComments) {
//        this.allComments = allComments;
//    }
//
//    public void  setAverageRating(String averageRating) {
//        this.averageRating = averageRating;
//    }



//    @DynamoDBHashKey(attributeName = "Id")
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    @DynamoDBAttribute(attributeName = "Name")
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @DynamoDBAttribute(attributeName = "DateCreated")
//    public Date getDateCreated() {
//        return dateCreated;
//    }
//
//    public void setDateCreated(Date dateCreated) {
//        this.dateCreated = dateCreated;
//    }
}
