package com.safeway.safeway.interfaces;

//import com.fingertips.model.AddTopicDoubtResponse;
//import com.fingertips.model.BoardsResponse;
//import com.fingertips.model.ChaptersResponse;
//import com.fingertips.model.ClassesResponse;
//import com.fingertips.model.FavouriteResponse;
//import com.fingertips.model.ForgetPasswordResponse;
//import com.fingertips.model.GetTopicDoubtsResponse;
//import com.fingertips.model.InstituteResponse;
//import com.fingertips.model.LoginResponse;
//import com.fingertips.model.MasteryQuizFirstQusResponse;
//import com.fingertips.model.MyQuizResponse;
//import com.fingertips.model.NextQuestionMasteryQuizResponse;
//import com.fingertips.model.OnBoardQuizResponse;
//import com.fingertips.model.PerformanceHistoryResponse;
//import com.fingertips.model.PerformanceViewResultQuizResponse;
//import com.fingertips.model.ProfileEditResponse;
//import com.fingertips.model.ProfileResponse;
//import com.fingertips.model.RegisterResponse;
//import com.fingertips.model.SearchResponse;
//import com.fingertips.model.SubjectResponse;
//import com.fingertips.model.TopicResponse;
//import com.fingertips.model.UnFavouriteResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

//import static com.safeway.safeway.interfaces.CommenUtils.Email;
//import static com.safeway.safeway.interfaces.CommenUtils.Password;

import com.safeway.safeway.models.request.AddVehicle;
import com.safeway.safeway.models.request.ReqForget;
import com.safeway.safeway.models.request.ReqLogin;
import com.safeway.safeway.models.request.ReqRegister;
import com.safeway.safeway.models.response.ApiResponse;

import java.util.Map;

/**
 * Created by Himanshu on 07/12/23.
 */

public interface ConfigURLs {
    @POST("auth/login")
    Call<ApiResponse> getLogin(@Body ReqLogin reqLogin);

    @POST("auth/signup")
    Call<ApiResponse> registerUser(@Body ReqRegister reqRegister);

    @POST("auth/forget")
    Call<ApiResponse> forgetUser(@Body ReqForget reqForget);

    @POST("user/vehicle")
    Call<ApiResponse> userVehicle(@HeaderMap Map<String, String> headerMap, @Body AddVehicle addVehicle);


//    @FormUrlEncoded
//    @POST("registerStudent")
//    Call<RegisterResponse> getRegister(@Field(Email) String email, @Field(Password) String password, @Field(Reg_key) String reg_key,
//                                       @Field(Device_id) String device_id, @Field(Score) String score, @Field(Subject_id) String subject_id,
//                                       @Field(Class_id) String class_id, @Field(Chapter_id) String chapter_id,
//                                       @Field(Question_Info) String question_info, @Field(Quiz_id) String quez_id);
//
//    @FormUrlEncoded
//    @POST("social_login")
//    Call<RegisterResponse> getRegisterWithFbOrGoogle(@Field(Email) String email,
//                                                     @Field(Reg_key) String reg_key, @Field(Device_id) String device_id,
//                                                     @Field(Score) String score, @Field(Subject_id) String subject_id,
//                                                     @Field(Class_id) String class_id, @Field(Chapter_id) String chapter_id,
//                                                     @Field(Question_Info) String question_info, @Field(Quiz_id) String quez_id);
//
//    @FormUrlEncoded
//    @Headers({"Accept: application/json", "Content-Type: application/json"})
//    @POST("auth/login")
//    Call<LoginResponse> getLogin(@Field(USERNAME) String username, @Field(PASSWORD) String password, @Field(Reg_key) String reg_key,
//                                 @Field(Device_id) String device_id);


//
//    @FormUrlEncoded
//    @POST("getClasses")
//    Call<ClassesResponse> getClasses(@Field(UserId) String userId);
//
//    @FormUrlEncoded
//    @POST("getBoards")
//    Call<BoardsResponse> getBoards(@Field(UserId) String userId);
//
//    @FormUrlEncoded
//    @POST("getSubjects")
//    Call<SubjectResponse> getSubject(@Field(Class_id) String classId, @Field(Timestamp) String timeStamp, @Field(UserId) String user_id);
//
//
//    @FormUrlEncoded
//    @POST("getChapters")
//    Call<ChaptersResponse> getChapters(@Field(Class_id) String classId, @Field(Subject_id) String SubjectId,
//                                       @Field(Timestamp) String timeStamp, @Field(UserId) String user_id);
//
//    @FormUrlEncoded
//    @POST("addTopicDoubt")
//    Call<AddTopicDoubtResponse> addTopicDoubts(@Field(Student_id) String student_id, @Field(Topic_id) String topic_id,
//                                               @Field(Message) String message, @Field(Image) String image);
//
//    @FormUrlEncoded
//    @POST("getTopicDoubts")
//    Call<GetTopicDoubtsResponse> getTopicDoubts(@Field(Topic_id) String topic_id);
//
//    @FormUrlEncoded
//    @POST("forgotPassword")
//    Call<ForgetPasswordResponse> forgetPassword(@Field(Email) String email);
//
//    @FormUrlEncoded
//    @POST("getTopics")
//    Call<TopicResponse> getTopics(@Field(Class_id) String class_id, @Field(Subject_id) String subject_id,
//                                  @Field(Chapter_id) String chapter_id, @Field(UserId) String user_id);
//
//    @FormUrlEncoded
//    @POST("getOnBoardQuiz")
//    Call<OnBoardQuizResponse> getOnBoard(@Field(Class_id) String class_id, @Field(Subject_id) String subject_id);
//
//
//    @FormUrlEncoded
//    @POST("getMyQuiz")
//    Call<MyQuizResponse> getMyQuiz(@Field(UserId) String user_id, @Field(Class_id) String class_id, @Field(Subject_id) String subject_id,
//                                   @Field(Chapter_id) String chapter_id, @Field(Topic_id) String topic_id);
//
//    @FormUrlEncoded
//    @POST("startMasterQuiz")
//    Call<MasteryQuizFirstQusResponse> getMasteryQuiz(@Field(UserId) String user_id, @Field(Class_id) String class_id, @Field(Subject_id) String subject_id,
//                                                     @Field(Chapter_id) String chapter_id);
//
//    @FormUrlEncoded
//    @POST("nextQuizQuestion")
//    Call<NextQuestionMasteryQuizResponse> getNextQuestionMasteryQuiz(@Field(UserId) String user_id, @Field(Class_id) String class_id, @Field(Subject_id) String subject_id,
//                                                                     @Field(Chapter_id) String chapter_id);
//
//    @FormUrlEncoded
//    @POST("viewProfile")
//    Call<ProfileResponse> getMyProfile(@Field(UserId) String user_id);
//
//    @FormUrlEncoded
//    @POST("editProfile")
//    Call<ProfileEditResponse> getEditProfile(@Field(UserId) String user_id, @Field(FName) String name, @Field(Class_id) String class_id);
//
//    @FormUrlEncoded
//    @POST("editProfile")
//    Call<ProfileEditResponse> getEditInstitute(@Field(UserId) String user_id,@Field(InstituteId) String institute_id);
//
//    @Multipart
//    @POST("editProfile")
//    Call<ProfileEditResponse> getEditUserImage(@Field(UserId) String user_id, @Part MultipartBody.Part image);
//
//    @FormUrlEncoded
//    @POST("totalQuizPlayed")
//    Call<PerformanceHistoryResponse> getPerformanceHistory(@Field(UserId) String user_id, @Field(Subject_id) String subject_id);
//
//    @FormUrlEncoded
//    @POST("quizInfo")
//    Call<PerformanceViewResultQuizResponse> getQuizId(@Field(Quiz_id) String quiz_id);
//
//    @FormUrlEncoded
//    @POST("getInstitutes")
//    Call<InstituteResponse> getInstitutes(@Field(UserId) String userId);
//
//    @FormUrlEncoded
//    @POST("setFavourite")
//    Call<FavouriteResponse> setFavourite(@Field(UserId) String userId, @Field(ContentId) String content_id);
//
//    @FormUrlEncoded
//    @POST("setUnFavourite")
//    Call<UnFavouriteResponse> setUnFavourite(@Field(UserId) String userId, @Field(ContentId) String content_id);
//
//    @FormUrlEncoded
//    @POST("searchKeywords")
//    Call<SearchResponse> getSearchKey(@Field(Class_id) String class_id, @Field(Subject_id) String subject_id/*, @Field(Searchkey) String key*/);
}
