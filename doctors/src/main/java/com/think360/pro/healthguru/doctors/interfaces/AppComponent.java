package com.think360.pro.healthguru.doctors.interfaces;


import com.think360.pro.healthguru.doctors.fragment.PatientsFragment;
import com.think360.pro.healthguru.doctors.utils.ApplicationModule;
import com.think360.pro.healthguru.doctors.utils.HttpModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {HttpModule.class, ApplicationModule.class})
public interface AppComponent {
     void inject(PatientsFragment fragment);
/*    void inject(CompletedScheduleDetailActivity activity);
    void inject(ContactToOperatorActivity activity);
    void inject(ChangeScheduleActivity activity);
    void inject(VerifyOtpActivity activity);
    void inject(NonApprovedActivity activity);
    void inject(AssignedScheduleDeatilActivity activity);
    void inject(AssignedScheduleDeatilActivity1 activity);
    void inject(SoSDetailActivity activity);
    void inject(ConfirmPasswordActivity activity);
    void inject(ForgetPasswordActivity activity);
    void inject(LoginActivity activity);
    void inject(AddAvailabilityActivity activity);
    void inject(HomeActivity activity);
    void inject(CompletedSchedulesActivity activity);

    void inject(ScheduleFragment fragment);
    void inject(ProfileFragment fragment);
    void inject(AvailabilityFragment fragment);
    void inject(SoSFragment fragment);
*/
    ApiService api();

}
