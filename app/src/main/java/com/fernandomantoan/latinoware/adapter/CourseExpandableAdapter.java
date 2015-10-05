package com.fernandomantoan.latinoware.adapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.fernandomantoan.latinoware.R;
import com.fernandomantoan.latinoware.model.Course;

public class CourseExpandableAdapter extends BaseExpandableListAdapter {
	private Calendar[] groups;
	private List<List<Course>> childs;
	private Activity activity;
	private LayoutInflater inflater;

	public CourseExpandableAdapter(Activity activity, 
			Calendar[] groups, List<Course> childs) {
		this.groups = groups;
		this.activity = activity;
		this.childs = new ArrayList<List<Course>>(groups.length);

		for(int i = 0; i < groups.length; i++) {
			this.childs.add(new ArrayList<Course>());
		}
		
		for(Course course : childs) {
			for(int i = 0; i < groups.length; i++) {
				if(course.occursInDate(groups[i])) {
					this.childs.get(i).add(course);
				}
			}
		}
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return this.childs.get(groupPosition).get(childPosition);
	}
	

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return this.childs.get(groupPosition).get(childPosition).getId();
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {

		if(convertView == null) {
			inflater = activity.getLayoutInflater();
			convertView = inflater.inflate(R.layout.course_list_item, parent, false);
		}
		
		Course course = this.childs.get(groupPosition).get(childPosition);
		
		TextView title = (TextView) convertView.findViewById(R.id.title);
		title.setText(course.getTitle());
		
		TextView teachers = (TextView) convertView.findViewById(R.id.teachers);
		if (course.getTeachers() != null) {
			teachers.setText(course.getTeachers().replace(",", "\n"));
		} else {
			teachers.setText("");
		}
		
		TextView lab = (TextView) convertView.findViewById(R.id.lab);
		lab.setText(course.getLab());
		
		TextView start = (TextView) convertView.findViewById(R.id.start);
		start.setText(course.getStartTime());
		
		TextView end = (TextView) convertView.findViewById(R.id.end);
		end.setText(course.getEndTime());
		
		return convertView;
	}
	
	@Override
	public int getChildrenCount(int groupPosition) {
		return this.childs.get(groupPosition).size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		return groups[groupPosition];
	}

	@Override
	public int getGroupCount() {
		return groups.length;
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		if(convertView == null) {
			inflater = activity.getLayoutInflater();
			convertView = inflater.inflate(android.R.layout.simple_expandable_list_item_1, parent, false);
		}
		TextView group = (TextView) convertView.findViewById(android.R.id.text1);
		group.setText(DateFormat.format("'Dia' dd", groups[groupPosition]));
		return convertView;
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return false;
	}
}