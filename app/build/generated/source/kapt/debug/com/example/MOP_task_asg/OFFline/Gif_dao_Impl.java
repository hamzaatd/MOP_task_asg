package com.example.MOP_task_asg.OFFline;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class Gif_dao_Impl implements Gif_dao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Giphy_gif_url> __insertionAdapterOfGiphy_gif_url;

  public Gif_dao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfGiphy_gif_url = new EntityInsertionAdapter<Giphy_gif_url>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `giftable` (`url`,`id`) VALUES (?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Giphy_gif_url value) {
        if (value.getUrl() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUrl());
        }
        stmt.bindLong(2, value.getId());
      }
    };
  }

  @Override
  public Object insert_gif_data(final Giphy_gif_url giphyGifUrl,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfGiphy_gif_url.insert(giphyGifUrl);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public LiveData<List<Giphy_gif_url>> get_allurl() {
    final String _sql = " select * from giftable";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"giftable"}, false, new Callable<List<Giphy_gif_url>>() {
      @Override
      public List<Giphy_gif_url> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<Giphy_gif_url> _result = new ArrayList<Giphy_gif_url>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Giphy_gif_url _item;
            final String _tmpUrl;
            if (_cursor.isNull(_cursorIndexOfUrl)) {
              _tmpUrl = null;
            } else {
              _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
            }
            _item = new Giphy_gif_url(_tmpUrl);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
