package com.interoligt.rougelike.Main;

public class Effect {
    private Target target;
    private int duration;
    private int counter;
    private boolean hasDuration, isContinuous, hasBeenApplied;
    private boolean isActive;

    private String name;
    private int value;
    private int totValue;
    private char stat, operator;


    Effect(String name, char stat, char operator, boolean isContinuous,
           int value, int duration) throws IllegalArgumentException {
        this(name, stat, operator, isContinuous, value);
        if (duration <= 0) {
            throw new IllegalArgumentException("If duration is added to " +
                    "constructor, the value has to be larger than 0");
        }
        this.duration = duration;
        counter = duration;
        hasDuration = true;
    }

    Effect(String name, char stat, char operator, boolean isContinuous,
           int value) throws IllegalArgumentException, NullPointerException {
        if (name == null || name.isBlank()) {
            throw new NullPointerException("Name cannot be null or blank");
        } else if (!(stat == 'd' || stat == 'h' || stat == 's') || !(operator == '+' ||
                operator == '-') || value <= 0) {
            throw new IllegalArgumentException("Stat has to be d (damage), " +
                    "h (health) or s (speed), operator has to be + or -, and " +
                    "value has to be a positive integer");
        }

        this.name = name;
        this.stat = stat;
        this.operator = operator;
        this.isContinuous = isContinuous;
        this.value = value;
        this.isActive = true;

    }

    boolean hasDuration() {
        return hasDuration;
    }

    boolean isContinuous() {
        return isContinuous;
    }

    boolean isActive() {
        return isActive;
    }

    void setTarget(Target newTarget) {
        if (target == null && newTarget != null) {
            this.target = newTarget;
            target.addEffect(this);
        } else if (newTarget == null && target != null) {
            removeEffect();
            target = null;
        }
    }

    int getDuration() {
        if (hasDuration) {
            return duration;
        } else {
            throw new NullPointerException("Effect has no duration.");
        }
    }

    double getValue() {
        return value;
    }

    int getValueWithSign() {
        if (operator == '-') {
            return -value;
        } else {
            return value;
        }
    }

    char getStat() {
        return stat;
    }

    int getCounter() {
        if (hasDuration) {
            return counter;
        } else {
            throw new NullPointerException("Effect has no duration.");
        }
    }

    void applyEffect() {
        if (isActive) {
            if (hasDuration && isContinuous) {
                applyContinuousDurationEffect();
            } else if (hasDuration) {
                applyDurationEffect();
            } else if (isContinuous) {
                applyContinuousEffect();
            } else {
                applySingleEffect();
            }
        }

    }

    private void applyContinuousDurationEffect() {
        if (counter > 0) {
            applyEffectSwitch();
        } else {
            removeEffect();
        }
        --counter;
    }

    private void applyDurationEffect() {
        if (counter > 0) {
            applySingleEffect();
        } else {
            removeEffect();
        }
        --counter;


    }

    private void applyContinuousEffect() {
        applyEffectSwitch();
    }

    private void applySingleEffect() {
        if (!hasBeenApplied) {
            applyEffectSwitch();
        }
        hasBeenApplied = true;
    }

    //Not private due to possible implementation of cleansing effects
    void removeEffect() {
        if (hasDuration && !isContinuous) {
            switch (stat) {
                case 'h':
                    target.changeHealth(-totValue);
                    break;
                case 's':
                    target.changeSpeed(-totValue);
                    break;
                case 'd':
                    target.changeDamage(-totValue);
                    break;
                default:
                    throw new IllegalArgumentException("Only h (health), " +
                            "s (speed) and d (damage) are valid inputs");
            }
        }

        isActive = false;
        target.removeEffect(this);
    }

    private void applyEffectSwitch() throws IllegalArgumentException {
        totValue += getValueWithSign();
        switch (stat) {
            case 'h':
                target.changeHealth(getValueWithSign());
                break;
            case 's':
                target.changeSpeed(getValueWithSign());
                break;
            case 'd':
                target.changeDamage(getValueWithSign());
                break;
            default:
                throw new IllegalArgumentException("Only h (health), s (speed) " +
                        "and d (damage) are valid inputs");
        }

    }

    //Break not used in switch since each case has return
    String getStatusName() {
        switch (stat) {
            case 'h':
                return "Health";
            case 's':
                return "Speed";
            case 'd':
                return "Damage";
            default:
                return "No Status";
        }
    }

    //Break not used in switch since each case has return
    private String getEffectType() {
        switch (operator) {
            case '+':
                return "Add";
            case '-':
                return "Subtract";
            default:
                return "No Effect";
        }
    }

    @Override
    public String toString() {
        String str = "Name: " + name + ", Stat: " + getStatusName() +
                ", Effect: " + getEffectType() + " " + value;
        if (isContinuous) {
            str += " each turn";
        }
        if (hasDuration) {
            str += ", Duration: " + duration + " turns";
        }
        return str;
    }
}
