package com.mine;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

/**
 * 
 * <p>
 * 描述：文件监控
 * </p>
 *
 * @Author patrick
 * @Date 2017年1月19日
 *
 */
public class FileWatchService {

	private WatchService watcher;

	public FileWatchService(Path path) {
		try {
			watcher = FileSystems.getDefault().newWatchService();
			path.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void handleEvents() {
		while (true) {
			try {
				WatchKey watchKey = watcher.take();
				watchKey.pollEvents().forEach(event -> {
					WatchEvent.Kind kind = event.kind();
					
					WatchEvent<Path> e = (WatchEvent<Path>) event;
					Path fileName = e.context();
					System.out.printf("Event %s has happened,which fileName is %s%n", kind.name(), fileName);
				});
				watchKey.reset();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new FileWatchService(Paths.get("F:\\demo")).handleEvents();
	}

}
