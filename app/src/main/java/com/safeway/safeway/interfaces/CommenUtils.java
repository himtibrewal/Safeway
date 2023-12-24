package com.safeway.safeway.interfaces;

import com.safeway.safeway.utility.ConfigureURLS;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Himanshu on 07/12/23.
 */

public interface CommenUtils {


    String NextQuizQuestion="nextQuizQuestion"; //url
    String FinishMasteryQuizURL="finishMasterQuiz"; //url


    String UserId="user_id";
    String ContentId="content_id";
    String USERNAME="username";
    String InstituteId="institute_id";
    String AccessToken="access_token";
    String AccessType="access_type";
    String PASSWORD="password";
    String Confirm_Password="password";
    String Reg_key="reg_key";
    String Searchkey="key";
    String Device_id="device_id";
    String Class_id="class_id";
    String Subject_id="subject_id";
    String Subject="subject";
    String Timestamp="timestamp";
    String Onboard="onboard";
    String SubjectId="subjectId";
    String Student_id="student_id";
    String Topic_id="topic_id";
    String Message="message";
    String Image="image";
    String Score="score";
    String Chapter_id="chapter_id";

    String MyquizOnBoard="myquizOnBoard";
    String FName="fname";
    String Name="name";
    String ClassTemp="class";
    String Chapter="chapter";
    String Position="position";
    String Permission="permission";
    String Points="points";
    String WeightedAvg="weighted_avg";
    String DataVLaue="data";
    String FromActivtiy="from";
    String SearchText="searchText";
    String SearchVideoFrag="search_video_frag";
    String SearchPdfFrag="search_pdf_frag";
    String ForgotPassword="forgotPassword";
    String SubName="subName";
    String Id="id";
    String Classid="classId";
    String ChageSub="chageSub";
    String CBSE="CBSE";
    String FileId="fileId";
    String FileName="fileName";
    String Type="type";
    String PDF="PDF";
    String VIDEO="VIDEO";
    String Qnsimage="qnsimage";
    String MyQuiz="MyQuiz";
    String TeachearQuiz="TeachearQuiz";
    String OnboardQiz="OnboardQiz";
    String SelectedOption="selectedOption";
    String DownloadTemp="download";
    String Status="status";
    String Quizz_id="quizz_id";
    String QuizScore="quiz_score";
    String Quiz_id="quiz_id";
    String Question_info="Question_info";
    String Question_Info="question_info";
    String SignupActivity="SignUpActivity";
    String TextType="textType";
    String Pdf_first_sec_pos="pdf_first_sec_pos";
    String ListTemp="list";
    String MasteryQuiz="masteryQuiz";
    String MasterQuestion="masterQuestion";
    String Master="master";
    String TopicId="topicId";
    String forTemp="for";
    String Correct="correct";
    String Wrong="wrong";
    String ChapterName="ChapterName";
    String Recomm_video_first_sec_pos="recomm_video_first_sec_pos";
    String MyQuizResult="myQizResult";
    String MasteryQuizResult="masteryQuizResult";
    String AchievementFragmentUtil="achievementFragmaent";
    String PerformanceHistory="performanceHistory";
    String TotalPoints="totalPoints";

    String Response_message="response_message";
    String Response_code="response_code";
    String Response_status="response_status";
    String Response_data="response_data";
    String Question_id="question_id";
    String Text_Type="text_type";
    String Topic="topic";
    String Question="question";
    String Opt_a="opt_a";
    String Opt_b="opt_b";
    String Opt_c="opt_c";
    String Opt_d="opt_d";
    String Option_a="option_a";
    String Option_b="option_b";
    String Option_c="option_c";
    String Option_d="option_d";
    String Answer="answer";
    String No_of_questions="no_of_questions";
    String Ans="ans";
    String QuestionId="questionId";
    String NextMastryQuestion="NextMastryQuestion";
    String FirstMastryQuestion="FirstMastryQuestion";

    String ResponseCodeFailure="201";
    String ResponseCodeSuccsess="200";
    String ResponseCodeFailure2="202";
    String ResponseCodeTimeError="500";

    String cannotConnectToInternet="Cannot connect to Internet...Please check your connection!";
}
