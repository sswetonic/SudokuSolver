public class BoardReaderFactory {
    public static BoardReader getReader(String fileName) {
        String extension = fileName.substring(fileName.indexOf('.'));
        if (extension.equals(".ss")) {
            return new SsBoardReader();
        } else {
            return new SdkBoardReader();
        }
    }
}
