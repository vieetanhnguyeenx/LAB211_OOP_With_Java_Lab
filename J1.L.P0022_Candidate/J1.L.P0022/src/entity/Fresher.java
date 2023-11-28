package entity;

public class Fresher extends Candidate{
    public enum GraduationRank {
        Excellence(0),
        Good(1),
        Fair(2),
        Poor(3);
        private int value;
        private GraduationRank(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }

    }
    private String graduationDate;
    private GraduationRank graduationRank;
    private String education;

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public GraduationRank getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(GraduationRank graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
}
