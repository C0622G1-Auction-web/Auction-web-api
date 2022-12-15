package com.project.dto.user;


import com.project.model.users.UserType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;


public class UserDto implements Validator {

    private Integer id;
    @NotEmpty(message = "Họ không được để trống")
    private String firstName;
    @NotEmpty(message = "Tên không được để trống")
    private String lastName;
    @NotEmpty(message = "Email không được để trống")
    private String email;
    @NotEmpty(message = "Số điện thoại không được để trống")
    private String phone;
    @NotNull(message = "Điểm cống hiến không được bỏ trống")
    @Min(value = 0, message = "Điểm cống hiến không được bé thua 0")
    @Max(value = 500, message = "Điểm cống hiến không được lớn hơn 500")
    private Double pointDedication;
    @NotEmpty(message = "Ngày sinh không được để trống")
    private String birthDay;
    @NotEmpty(message = "CMND không được để trống")
    private String idCard;
    @NotEmpty(message = "Avatar được để trống")
    private String avatar;
    private Boolean deleteStatus;
    private AddressDto addressDto;
    private AccountDto accountDto;
    private List<String> emailList;
    private UserType userType;

    public UserDto( ) {
    }

    public UserDto(String firstName, String lastName, String email, String phone, Double pointDedication, String birthDay, String idCard, String avatar, AddressDto addressDto, AccountDto accountDto) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.pointDedication = pointDedication;
        this.birthDay = birthDay;
        this.idCard = idCard;
        this.avatar = avatar;
        this.addressDto = addressDto;
        this.accountDto = accountDto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getPointDedication() {
        return pointDedication;
    }

    public void setPointDedication(Double pointDedication) {
        this.pointDedication = pointDedication;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public AddressDto getAddressDto() {
        return addressDto;
    }

    public void setAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
    }

    public AccountDto getAccountDto() {
        return accountDto;
    }

    public void setAccountDto(AccountDto accountDto) {
        this.accountDto = accountDto;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

        /**
         * Create by: TruongLH
         * Date created: 13/12/2022
         * Function: to validate all field in user
         */
        @Override
        public void validate(Object target, Errors errors) {
            UserDto userDto = (UserDto) target;
            if (userDto.getFirstName().equals("")) {
                errors.rejectValue("firstName", "firstName", "Họ không được bỏ trống");
            } else {
                if (!userDto.getFirstName().matches("^[a-zA-Z_ÀÁÂÃÈÉÊẾÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]{2,30}$")) {
                    errors.rejectValue("firstName", "firstName", "Họ không đúng định dạng !");
                }
            }
            if (userDto.getLastName().equals("")) {
                errors.rejectValue("lastName", "lastName", "Tên không được bỏ trống");
            } else {
                if (!userDto.getLastName().matches("^[a-zA-Z_ÀÁÂÃÈÉÊẾÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]{2,30}$")) {
                    errors.rejectValue("lastName", "lastName", "Tên không đúng định dạng !");
                }
            }
            for (String email : userDto.emailList) {
                if (email.equals(userDto.getEmail())) {
                    errors.rejectValue("email", "email", "Email đã tồn tại");
                }
            }
            if (userDto.getEmail().equals("")) {
                errors.rejectValue("email", "email", "Email không được bỏ trông");
            } else {
                if (!userDto.getEmail().matches("^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")) {
                    errors.rejectValue("email", "email", "Email must be valid");
                }
            }
            if (userDto.getIdCard().equals("")) {
                errors.rejectValue("idCard", "idCard", "CMND không được bỏ trống");
            } else {
                if (!(userDto.getIdCard().matches("\\d{9}") ||
                        userDto.getIdCard().matches("\\d{12}"))) {
                    errors.rejectValue("idCard", "idCard", "CMND chỉ có 9 số hoặc 12 số");
                }
            }
            if (userDto.getPhone().equals("")) {
                errors.rejectValue("phoneNumber", "phoneNumber", "Số điện thoại không được để trống");
            } else {
                if (!(userDto.getPhone().matches("[0][9][0]\\d{7}") ||
                        userDto.getPhone().matches("[0][9][1]\\d{7}") ||
                        userDto.getPhone().matches("[(][8][4][)][+][9][0]\\d{7}") ||
                        userDto.getPhone().matches("[(][8][4][)][+][9][1]\\d{7}"))) {
                    errors.rejectValue("phone", "phone", "Số điện thoại có định dang  (090xxxxxxx) hoặc (091xxxxxxx) hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx");
                }
            }
            if (userDto.getAvatar().equals("")) {
                errors.rejectValue("avatar", "avatar", "Avatar không được để trống");
            }
            for (String username : userDto.emailList) {
                if (username.equals(userDto.accountDto.getUsername())) {
                    errors.rejectValue("username", "username", "Tên đăng nhập đã tồn tại đã tồn tại");
                }
            }
            if (userDto.addressDto.getDetailAddress().equals("")) {
                errors.rejectValue("town", "town", "Phường xã không được để trống");
            } else {
                if (!(userDto.addressDto.getTown().matches("\"^[a-zA-Z_ÀÁÂÃÈÉÊẾÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]{5,30}$"))) {
                    errors.rejectValue("town", "town", "Phường xã nhập từ 5 tới 30 kí tự");
                }
            }
            if (userDto.addressDto.getDistrict().equals("")) {
                errors.rejectValue("district", "district", "Quận huyện không được để trống");
            } else {
                if (!(userDto.addressDto.getTown().matches("\"^[a-zA-Z_ÀÁÂÃÈÉÊẾÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]{5,30}$"))) {
                    errors.rejectValue("district", "district", "Quận huyện nhập từ 5 tới 30 kí tự");
                }
            }
            if (userDto.addressDto.getCity().equals("")) {
                errors.rejectValue("city", "city", "Tỉnh thành không được để trống");
            } else {
                if (!(userDto.addressDto.getTown().matches("\"^[a-zA-Z_ÀÁÂÃÈÉÊẾÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]{5,30}$"))) {
                    errors.rejectValue("city", "city", "Tỉnh thành nhập từ 5 tới 30 kí tự");
                }
            }
            if (userDto.addressDto.getCountry().equals("")) {
                errors.rejectValue("country", "country", "Đất Nước không được để trống");
            } else {
                if (!(userDto.addressDto.getTown().matches("\"^[a-zA-Z_ÀÁÂÃÈÉÊẾÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]{5,30}$"))) {
                    errors.rejectValue("country", "country", "Quốc gia nhập từ 5 tới 30 kí tự");
                }
            }
        }
}