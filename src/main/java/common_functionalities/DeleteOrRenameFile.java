package common_functionalities;

import java.io.File;

public class DeleteOrRenameFile {

	public final static File parentDir = new File("./src/main/java");

	public static boolean deleteFile(File fileName) {
		return fileName.delete();
	}

	public static boolean renameFile(File oldFile, File newFile) {
		return newFile.renameTo(oldFile);
	}

}
