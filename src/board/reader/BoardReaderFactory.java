package board.reader;


import jdk.jshell.spi.ExecutionControl;

public class BoardReaderFactory {
    public static BoardReader getReader(String filePath) throws ExecutionControl.NotImplementedException {
        int i = filePath.lastIndexOf('.');
        if (i > 0) {
            String extension = filePath.substring(i + 1);
            if (extension.equalsIgnoreCase("sdk")) {
                return new SdkBoardReader();

            } else if (extension.equalsIgnoreCase("ss")) {
                return new SsBoardReader();
            }
            throw new ExecutionControl.NotImplementedException("File format " + extension + " is not supported.");
        }

        throw new UnsupportedOperationException("File has no extension.");
    }
}
