// 유효성 검사
List<String> errorList = new ArrayList<>();
String itemCodeZero = String.format("%016d", Integer.parseInt(info.getSdaId()));
info.setSdaId(itemCodeZero);

Map<String, Integer> checkMovieArchives = validateData(info, errorList);

if (!errorList.isEmpty()) {
    modelMap.addAttribute("resCode", "999");
    return "jsonView";
}


private Map<String, Integer> validateData(MovieArchivesVO info, List<String> errorList) {
    List<Map<String, Object>> checkMovieArchives = movieArchivesService.checkArchivesExistence(info);

    checkMovieArchives.stream()
            .collect(Collectors.toMap(
                    row -> (String) row.get("COLUMN_NAME"),
                    row -> Optional.ofNullable(row.get("COUNT_VALUE"))
                            .filter(BigDecimal.class::isInstance)
                            .map(BigDecimal.class::cast)
                            .map(BigDecimal::intValue)
                            .orElse(0)
            ));

    boolean seriesNotFound = (checkMovieArchives.get("SERIES_SEQ").equals(0)) ? true : false;
    boolean sdaIdNotFound = (checkMovieArchives.get("SDA_ID_EXIST").equals(0)) ? true : false;
    boolean isDuplicateSdaId = (!checkMovieArchives.get("SDA_ID_VALID").equals(0)) ? true : false;
    boolean isDuplicateVideoKey = (!checkMovieArchives.get("VIDEO_KEY").equals(0)) ? true : false;

    if (seriesNotFound) {
        modelMap.addAttribute("smallCategory-error", "존재하지 않는 시리즈명입니다.");
        errorList.add("smallCategory-error");
    }
    if (sdaIdNotFound) {
        modelMap.addAttribute("sdaId-error", "해당 SDA_ID의 기록물이 없습니다.");
        errorList.add("sdaId-error");
    }
    if (isDuplicateSdaId) {
        modelMap.addAttribute("sdaId-error", "이미 등록된 SDA_ID 입니다.");
        errorList.add("sdaId-error");
    }
    if (isDuplicateVideoKey) {
        modelMap.addAttribute("videoKey-error", "이미 등록된 비디오키입니다.");
        errorList.add("videoKey-error");
    }

    return errorList;
}