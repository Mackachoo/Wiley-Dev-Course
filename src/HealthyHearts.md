PRINT("What is your age?")

INT age = INPUT()

INT maxHR = 220 - age

INT[] hrRange = {maxHR * 0.5, maxHR * 0.85}

PRINF("Your maximum heart rate should be %d beats per minute", maxHR)

PRINTF("Your target HR Zone is %d - %d beats per minute", hrRange[0], hrRange[1])
