package com.xxmicloxx.NoteBlockAPI;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class SongDestroyingEvent extends Event implements Cancellable {

    public enum StopCause {
        END,
        MANUALLY_DESTROYED
    }

    private static final HandlerList handlers = new HandlerList();
    private SongPlayer song;
    private boolean cancelled = false;
    private StopCause cause = StopCause.MANUALLY_DESTROYED;

    public SongDestroyingEvent(SongPlayer song, StopCause sc) {
        this.song = song;
        this.cause = sc;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public SongPlayer getSongPlayer() {
        return song;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public StopCause getStoppedCause(){ return cause; }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean arg0) {
        cancelled = arg0;
    }
}
